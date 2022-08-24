package eu.fooder.controllers;

import eu.fooder.models.Provider;
import eu.fooder.services.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProviderService providerService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("providers", providerService.getAllProviders());
        model.addAttribute("provider", new Provider());
        return "main";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
