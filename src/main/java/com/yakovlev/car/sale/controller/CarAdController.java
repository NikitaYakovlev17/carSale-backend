package com.yakovlev.car.sale.controller;

import com.dropbox.core.DbxException;
import com.yakovlev.car.sale.dto.carAd.CarAdDto;
import com.yakovlev.car.sale.dto.carPhoto.CarPhotoDto;
import com.yakovlev.car.sale.dto.user.UserDto;
import com.yakovlev.car.sale.model.CarAd;
import com.yakovlev.car.sale.model.CarAdPage;
import com.yakovlev.car.sale.model.CarAdSearchCriteria;
import com.yakovlev.car.sale.model.CarPhoto;
import com.yakovlev.car.sale.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@Transactional
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/car-ad")
public class CarAdController {
    private final CarAdService carAdService;
    private final UserService userService;
    private final FileService fileService;
    private final CarPhotoService carPhotoService;
    private final DropboxService dropboxService;


    @GetMapping
    public List<CarAdDto> getAll(){
        return carAdService.getAll();
    }

    @GetMapping("/{id}")
    public CarAdDto getById(@PathVariable Long id){
        return carAdService.getDtoById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        List<UserDto> userDtos = userService.findUsersByLikedCarAds(id);
        for (UserDto userDto: userDtos) {
            userService.dislikeCarAd(userDto.getId(), id);
        }
        carAdService.deleteById(id);
    }

    @GetMapping(".../filter")
    public ResponseEntity<List<CarAdDto>> getCarAds(CarAdPage carAdPage, CarAdSearchCriteria carAdSearchCriteria){
        return new ResponseEntity<>(carAdService.getCarAds(carAdPage, carAdSearchCriteria),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{carAdId}/file", method = RequestMethod.POST)
    public @ResponseBody
    void postFileUpload(@RequestParam("file") MultipartFile file,
                        @PathVariable Long carAdId) throws Exception {
        CarAd carAd = carAdService.getById(carAdId);
        String extension = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
        String newFileName = fileService.saveFile(extension, "carAdPhotos", file);
        CarPhoto carPhoto = CarPhoto
                .builder()
                .path(newFileName + "." + extension)
                .carAd(carAd)
                .build();
        carPhotoService.savePhoto(carPhoto);
    }

    @RequestMapping(value = "/file/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> provideUploadInfo(@PathVariable Long id) throws IOException, DbxException {
        CarPhoto carPhoto = carPhotoService.getPhoto(id);
        String path = carPhoto.getPath();
        var outputStream = dropboxService.getFile("/carAdPhotos/" + path);
        byte[] bytes = outputStream.toByteArray();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        String extension = path.split("\\.")[1];

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("image/" + extension))
                //.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + path + "\"")
                .body(new InputStreamResource(inputStream));
    }

    @GetMapping("/file/{id}/all")
    public List<CarPhotoDto> getAllByCarAdId(@PathVariable Long id){
        return carPhotoService.getAllByCarAdId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method= RequestMethod.POST, value = "/add")
    @ResponseBody
    public Long add(@Valid @RequestBody CarAdDto carAdDto){
        CarAd carAd = carAdService.add(carAdDto);
        return carAd.getId();
    }

    @GetMapping("/{id}/liked")
    public List<CarAdDto> getLiked(@PathVariable Long id){
        return carAdService.getLiked(id);
    }

    @GetMapping("/{id}/all")
    public List<CarAdDto> allUserCarAd(@PathVariable Long id){
        return carAdService.allUserCarAd(id);
    }
}
