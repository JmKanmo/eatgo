package kr.co.fastcampus.eatgo.interfaces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Main view API"})
@RestController
public class WelcomeController {
    @ApiOperation(value = "메인뷰", notes = "메인뷰를 보여준다.")
    @GetMapping("/")
    public String hello(){
        return "hello798798";
    }
}
