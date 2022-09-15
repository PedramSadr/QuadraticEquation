package com.adv.demo.service;

import com.adv.demo.model.Params;
import com.adv.demo.model.ResponseEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Configuration
@PropertySource("classpath:application.properties")
public class AlgebraService {

//    @Autowired
//    private Environment env;

    private Environment env;

    public AlgebraService(Environment environment) {
        this.env = environment;
    }

    public ResponseEntity findRoots(Params params){

        ResponseEntity responseEntity = new ResponseEntity();

        Double a4 = params.getCoefficientA().doubleValue() * 4;
        Double cPart = a4.doubleValue() * params.getConstant().doubleValue();
        Double sqrt = Math.sqrt(Math.pow(params.getCoefficientB().doubleValue(),2) - cPart.doubleValue());

        Double x1 = ((-params.getCoefficientB().doubleValue() - sqrt) / 2 * params.getCoefficientA().doubleValue());
        Double x2 = ((-params.getCoefficientB().doubleValue() + sqrt) / 2 * params.getCoefficientA().doubleValue());

        responseEntity.setX1(x1);
        responseEntity.setX2(x2);
        String message = getProperMessageForRoots(sqrt);
        responseEntity.setMessage(message);

        return responseEntity;
    }

    private String getProperMessageForRoots(Double discriminant) {

        String msg = null;
        if (discriminant.doubleValue() > 0)
            msg = env.getProperty("discriminant.greater.than.zero");
        else if(discriminant.doubleValue() == 0)
            msg = env.getProperty("discriminant.equal.to.zero");
        else
            msg = env.getProperty("discriminant.less.than.zero");

        return msg;
    }
}
