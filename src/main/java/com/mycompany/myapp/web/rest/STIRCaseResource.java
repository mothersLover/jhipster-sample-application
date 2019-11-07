package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.STIRCase;
import com.mycompany.myapp.repository.STIRCaseRepository;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.STIRCase}.
 */
@RestController
@RequestMapping("/api")
public class STIRCaseResource {

    private final Logger log = LoggerFactory.getLogger(STIRCaseResource.class);

    private static final String ENTITY_NAME = "sTIRCase";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final STIRCaseRepository sTIRCaseRepository;

    public STIRCaseResource(STIRCaseRepository sTIRCaseRepository) {
        this.sTIRCaseRepository = sTIRCaseRepository;
    }

    /**
     * {@code POST  /stir-cases} : Create a new sTIRCase.
     *
     * @param sTIRCase the sTIRCase to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sTIRCase, or with status {@code 400 (Bad Request)} if the sTIRCase has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/stir-cases")
    public ResponseEntity<STIRCase> createSTIRCase(@RequestBody STIRCase sTIRCase) throws URISyntaxException {
        log.debug("REST request to save STIRCase : {}", sTIRCase);
        if (sTIRCase.getId() != null) {
            throw new BadRequestAlertException("A new sTIRCase cannot already have an ID", ENTITY_NAME, "idexists");
        }
        STIRCase result = sTIRCaseRepository.save(sTIRCase);
        return ResponseEntity.created(new URI("/api/stir-cases/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /stir-cases} : Updates an existing sTIRCase.
     *
     * @param sTIRCase the sTIRCase to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sTIRCase,
     * or with status {@code 400 (Bad Request)} if the sTIRCase is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sTIRCase couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/stir-cases")
    public ResponseEntity<STIRCase> updateSTIRCase(@RequestBody STIRCase sTIRCase) throws URISyntaxException {
        log.debug("REST request to update STIRCase : {}", sTIRCase);
        if (sTIRCase.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        STIRCase result = sTIRCaseRepository.save(sTIRCase);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, sTIRCase.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /stir-cases} : get all the sTIRCases.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sTIRCases in body.
     */
    @GetMapping("/stir-cases")
    public List<STIRCase> getAllSTIRCases() {
        log.debug("REST request to get all STIRCases");
        return sTIRCaseRepository.findAll();
    }

    /**
     * {@code GET  /stir-cases/:id} : get the "id" sTIRCase.
     *
     * @param id the id of the sTIRCase to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sTIRCase, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/stir-cases/{id}")
    public ResponseEntity<STIRCase> getSTIRCase(@PathVariable Long id) {
        log.debug("REST request to get STIRCase : {}", id);
        Optional<STIRCase> sTIRCase = sTIRCaseRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(sTIRCase);
    }

    /**
     * {@code DELETE  /stir-cases/:id} : delete the "id" sTIRCase.
     *
     * @param id the id of the sTIRCase to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/stir-cases/{id}")
    public ResponseEntity<Void> deleteSTIRCase(@PathVariable Long id) {
        log.debug("REST request to delete STIRCase : {}", id);
        sTIRCaseRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
