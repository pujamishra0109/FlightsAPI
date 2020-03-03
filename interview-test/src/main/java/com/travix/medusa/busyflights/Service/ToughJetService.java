package com.travix.medusa.busyflights.Service;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Puja on 28/02/20.
 */
@Service
public interface ToughJetService {
    public ResponseEntity<List<ToughJetResponse> >getToughJet(ToughJetRequest toughJetRequest) throws Exception;

}
