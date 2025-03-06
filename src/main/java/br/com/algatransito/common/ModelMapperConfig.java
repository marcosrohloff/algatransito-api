package br.com.algatransito.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.algatransito.api.model.VeiculoModel;
import br.com.algatransito.domain.model.Veiculo;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Veiculo.class, VeiculoModel.class)
            .addMappings(m -> m.map(Veiculo::getPlaca, VeiculoModel::setNumeroPlaca));
        
        return modelMapper;
    }
}
