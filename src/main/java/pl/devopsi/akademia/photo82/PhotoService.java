package pl.devopsi.akademia.photo82;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@AllArgsConstructor

public class PhotoService {
    private final Map<Long, Photo> photos;
    private final PhotoMapper photoMapper;
    private final PhotoRepository photoRepository;
    private final LocationRepository locationRepository;

    public void addPhoto (PhotoDto photoDto){
        Photo photo = photoMapper.map(photoDto);
        UpLoadHistory upLoadHistory = new UpLoadHistory();

        Set<Photo>photos=new HashSet<>();
        Location location = new Location();

        upLoadHistory.setDate(new Date());
        upLoadHistory.setPhoto(photo);
        photo.setUpLoadHistory(upLoadHistory);



        photo.setLocation(location);
        location.setPhotos(photos);
        photoRepository.save(photo);
    }

    public void updatePhoto (Long id, Photo photo){
        if(photoRepository.existsById(id)){
            Photo registeredPhoto = photoRepository.findById(id).get();
            registeredPhoto.setTitle(photo.getTitle());
            registeredPhoto.setDescription(photo.getDescription());
            registeredPhoto.setPrivacy(photo.getPrivacy());
            registeredPhoto.setUpLoaderName(photo.getUpLoaderName());
            registeredPhoto.setUpLoaderPhoneNum(photo.getUpLoaderPhoneNum());
            registeredPhoto.setEmail(photo.getEmail());
            registeredPhoto.setAddress(photo.getAddress());
            registeredPhoto.setView(photo.getAddress());
            photoRepository.save(registeredPhoto);
        } else {
            throw new PhotoException("Photo with id  "+id+" not exists");
        }

    }

    public void deletePhoto (Long id){
        if(photoRepository.findById(id).isPresent()){
            photoRepository.deleteById(id);
        }else{
            throw new PhotoException("Photo with id:  " + id + " not exists");
        }
    }

    public List<Photo> getPhotos() {
        return photoRepository.findAll();
    }

}
