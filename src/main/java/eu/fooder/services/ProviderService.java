package eu.fooder.services;

import eu.fooder.models.Provider;
import eu.fooder.repositories.ProviderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepo repo;

    public List<Provider> getAllProviders() {
        return (List<Provider>) repo.findAll();
    }

    public Provider addNewProvider(Provider provider) {
        return repo.save(provider);
    }

    public Provider getProviderById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteProvider(Long id) {
        repo.deleteById(id);
        return "Provider was deleted.";
    }

}
