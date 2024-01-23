package com.cajeroautomatico.tasacambio.service;


import com.cajeroautomatico.tasacambio.dto.TasaDeCambioRequest;
import com.cajeroautomatico.tasacambio.dto.TasaDeCambioResponse;
import com.cajeroautomatico.tasacambio.respository.TasaDeCambioEntity;
import com.cajeroautomatico.tasacambio.respository.TasaDeCambioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TasaDeCambioService {
    TasaDeCambioRepository tasaDeCambioRepository;
    public TasaDeCambioService(TasaDeCambioRepository tasaDeCambioRepository){
        this.tasaDeCambioRepository=tasaDeCambioRepository;
    }

    private TasaDeCambioResponse convertirEntityAResponse(TasaDeCambioEntity entity){
        return TasaDeCambioResponse.builder()
                .moneda(entity.getMoneda())
                .tipoCambioCompra(entity.getTipoCambioCompra())
                .tipoCambioVenta(entity.getTipoCambioVenta())
                .build();
    }


    public TasaDeCambioResponse modifyTasaDeCambio(TasaDeCambioRequest request){
        Optional<TasaDeCambioEntity>  tasaDeCambioOpt=tasaDeCambioRepository.findById( request.getMoneda() );
        if(tasaDeCambioOpt.isPresent()){
            TasaDeCambioEntity tasaDeCambioEntity=tasaDeCambioOpt.get();
            tasaDeCambioEntity.setTipoCambioVenta(request.getTipoCambioVenta());
            tasaDeCambioEntity.setTipoCambioCompra(request.getTipoCambioCompra());
            tasaDeCambioRepository.save(tasaDeCambioEntity);
            return  convertirEntityAResponse(tasaDeCambioEntity);
        }
        return TasaDeCambioResponse.builder().build();


    }
    public TasaDeCambioResponse findByIdTasaDeCambio(String moneda){
        Optional<TasaDeCambioEntity> optionalTasaDeCambioEntity=tasaDeCambioRepository.findById(moneda);
        if (optionalTasaDeCambioEntity.isPresent()){
            TasaDeCambioEntity tasaDeCambioEntity=optionalTasaDeCambioEntity.get();
            return  convertirEntityAResponse(tasaDeCambioEntity);
        }
        return TasaDeCambioResponse.builder().build();
    }



    public List<TasaDeCambioResponse> findAllTasaDeCambio() {
        List<TasaDeCambioEntity>  lista=tasaDeCambioRepository.findAll();
        List<TasaDeCambioResponse> responseList=new ArrayList<>();
        for(TasaDeCambioEntity bean:lista){
            responseList.add( convertirEntityAResponse(bean ));
        }
        return responseList;
    }
}
