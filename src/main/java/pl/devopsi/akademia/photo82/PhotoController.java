package pl.devopsi.akademia.photo82;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/photos")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @PostMapping("/photo")
    public ResponseEntity<Void> addPhoto (@RequestBody PhotoDto photoDto){
        this.photoService.addPhoto(photoDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/photo/{id}")
    public ResponseEntity<Photo>updatePhoto(@PathVariable Long id, @RequestBody Photo photo){
        this.photoService.updatePhoto(id, photo);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/photo/{id}")
    public ResponseEntity<Void>deletePhoto(@PathVariable Long id){
        this.photoService.deletePhoto(id);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/photo")
    public ResponseEntity <List<Photo>> getPhotos(){
        List<Photo>photos=this.photoService.getPhotos();
        return ResponseEntity.status(HttpStatus.OK)
                .body(photos);
    }
}
