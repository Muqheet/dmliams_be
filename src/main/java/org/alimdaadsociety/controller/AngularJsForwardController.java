package org.alimdaadsociety.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AngularJsForwardController
{
//	@GetMapping("/**/{[path:[^\\.]*}")
	@GetMapping("/")
    public String redirect() {
//        return "forward:/";
		return "redirect:https://alimdaadsociety.org";
    }
}
