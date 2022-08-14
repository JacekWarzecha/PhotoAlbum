package pl.devopsi.akademia.photo82;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PhotoDto {
    private final String title;
    private final String description;
    private final String privacy;
    private final String upLoaderName;
    private final String upLoaderPhoneNum;
    private final String email;
    private final String address;
    private final String view;
    private final String locationName;
    private final String locationShortName;

}
