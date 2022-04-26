package com.yakovlev.car.sale.controller;

import com.dropbox.core.DbxException;
import com.yakovlev.car.sale.dto.carAd.CarAdDto;
import com.yakovlev.car.sale.dto.generation.GenerationDto;
import com.yakovlev.car.sale.dto.model.ModelDto;
import com.yakovlev.car.sale.dto.producer.ProducerDto;
import com.yakovlev.car.sale.model.*;
import com.yakovlev.car.sale.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/car-ad")
public class CarAdController {
    private final CarAdService carAdService;
    private final ProducerService producerService;
    private final ModelService modelService;
    private final GenerationService generationService;
    private final FileService fileService;
    private final CarPhotoService carPhotoService;
    private final DropboxService dropboxService;

    @GetMapping("/producers")
    public List<ProducerDto> getAllProducers(){
        return producerService.getAll();
    }

    @GetMapping
    public List<CarAdDto> getAll(){
        return carAdService.getAll();
    }

    @GetMapping("id/{id}")
    public CarAdDto getById(@PathVariable Long id){
        return carAdService.getById(id);
    }

    @GetMapping("/{producer}")
    public List<ModelDto> getAllModelsByProducerName(@PathVariable String producer){
        return modelService.getAllByProducerName(producer);
    }

    @GetMapping("/producer/{model}")
    public List<GenerationDto> getAllGenerationsByModelName(@PathVariable String model){
        return generationService.getAllByModelName(model);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<CarAdDto>> getCarAds(CarAdPage carAdPage, CarAdSearchCriteria carAdSearchCriteria){
        return new ResponseEntity<>(carAdService.getCarAds(carAdPage, carAdSearchCriteria),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{carAdId}/file", method = RequestMethod.POST)
    public @ResponseBody
    void postFileUpload(@RequestParam("file") MultipartFile file,
                        @PathVariable Long carAdId) throws Exception {

        String extension = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
        String newFileName = fileService.saveFile(extension, "carAdPhotos", file);
        CarPhoto carPhoto = CarPhoto
                .builder()
                .path(newFileName + "." + extension)
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

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + path + "\"")
                .body(new InputStreamResource(inputStream));
    }
}
