package pl.devopsi.akademia.photo82;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel ="spring")
public interface PhotoMapper {
    @Mapping(source="locationName",target="name")
    @Mapping(source="locationShortName", target="shortName")
    Photo map (PhotoDto photoCreateDto);
}
