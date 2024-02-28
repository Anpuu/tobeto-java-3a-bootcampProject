package tobeto.bootcamppoject.core.utilities.modelmapper;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperServiceImpl implements ModelMapperService {

    private ModelMapper modelMapper;

    @Override
    public ModelMapper forRequest() {
      this.modelMapper.getConfiguration().setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
      return modelMapper;
    }

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }
}

// TODO : Mapper mantıgını kavramak için mapper yazıp araştır.
