package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.ArchiveApp;
import com.mycompany.myapp.domain.STIRCase;
import com.mycompany.myapp.repository.STIRCaseRepository;
import com.mycompany.myapp.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static com.mycompany.myapp.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link STIRCaseResource} REST controller.
 */
@SpringBootTest(classes = ArchiveApp.class)
public class STIRCaseResourceIT {

    private static final String DEFAULT_ENTITY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ENTITY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ENTITY = "AAAAAAAAAA";
    private static final String UPDATED_ENTITY = "BBBBBBBBBB";

    private static final String DEFAULT_LSDB_ID = "AAAAAAAAAA";
    private static final String UPDATED_LSDB_ID = "BBBBBBBBBB";

    private static final String DEFAULT_RELATIONSHIP = "AAAAAAAAAA";
    private static final String UPDATED_RELATIONSHIP = "BBBBBBBBBB";

    private static final String DEFAULT_VENDOR_RA_GSTATUS = "AAAAAAAAAA";
    private static final String UPDATED_VENDOR_RA_GSTATUS = "BBBBBBBBBB";

    private static final String DEFAULT_EXPLANATION_OF_ESTIMATE = "AAAAAAAAAA";
    private static final String UPDATED_EXPLANATION_OF_ESTIMATE = "BBBBBBBBBB";

    private static final String DEFAULT_REP_RISK_CONCERNS = "AAAAAAAAAA";
    private static final String UPDATED_REP_RISK_CONCERNS = "BBBBBBBBBB";

    private static final String DEFAULT_RELATIONSHIP_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_RELATIONSHIP_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_I_1_NA = "AAAAAAAAAA";
    private static final String UPDATED_I_1_NA = "BBBBBBBBBB";

    private static final String DEFAULT_I_2_NA = "AAAAAAAAAA";
    private static final String UPDATED_I_2_NA = "BBBBBBBBBB";

    private static final String DEFAULT_I_3_NA = "AAAAAAAAAA";
    private static final String UPDATED_I_3_NA = "BBBBBBBBBB";

    private static final String DEFAULT_I_4_NA = "AAAAAAAAAA";
    private static final String UPDATED_I_4_NA = "BBBBBBBBBB";

    private static final String DEFAULT_I_5_NA = "AAAAAAAAAA";
    private static final String UPDATED_I_5_NA = "BBBBBBBBBB";

    private static final String DEFAULT_I_6_NA = "AAAAAAAAAA";
    private static final String UPDATED_I_6_NA = "BBBBBBBBBB";

    private static final String DEFAULT_I_7_NA = "AAAAAAAAAA";
    private static final String UPDATED_I_7_NA = "BBBBBBBBBB";

    private static final String DEFAULT_I_8_NA = "AAAAAAAAAA";
    private static final String UPDATED_I_8_NA = "BBBBBBBBBB";

    private static final String DEFAULT_I_9_NA = "AAAAAAAAAA";
    private static final String UPDATED_I_9_NA = "BBBBBBBBBB";

    private static final String DEFAULT_I_10_NA = "AAAAAAAAAA";
    private static final String UPDATED_I_10_NA = "BBBBBBBBBB";

    private static final String DEFAULT_I_11_NA = "AAAAAAAAAA";
    private static final String UPDATED_I_11_NA = "BBBBBBBBBB";

    private static final String DEFAULT_I_12_NA = "AAAAAAAAAA";
    private static final String UPDATED_I_12_NA = "BBBBBBBBBB";

    private static final String DEFAULT_INDICATOR_DISCUSS_1 = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_DISCUSS_1 = "BBBBBBBBBB";

    private static final String DEFAULT_INDICATOR_DISCUSS_2 = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_DISCUSS_2 = "BBBBBBBBBB";

    private static final String DEFAULT_INDICATOR_DISCUSS_3 = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_DISCUSS_3 = "BBBBBBBBBB";

    private static final String DEFAULT_INDICATOR_DISCUSS_4 = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_DISCUSS_4 = "BBBBBBBBBB";

    private static final String DEFAULT_INDICATOR_DISCUSS_5 = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_DISCUSS_5 = "BBBBBBBBBB";

    private static final String DEFAULT_INDICATOR_DISCUSS_6 = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_DISCUSS_6 = "BBBBBBBBBB";

    private static final String DEFAULT_INDICATOR_DISCUSS_7 = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_DISCUSS_7 = "BBBBBBBBBB";

    private static final String DEFAULT_INDICATOR_DISCUSS_8 = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_DISCUSS_8 = "BBBBBBBBBB";

    private static final String DEFAULT_INDICATOR_DISCUSS_9 = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_DISCUSS_9 = "BBBBBBBBBB";

    private static final String DEFAULT_INDICATOR_DISCUSS_10 = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_DISCUSS_10 = "BBBBBBBBBB";

    private static final String DEFAULT_INDICATOR_DISCUSS_11 = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_DISCUSS_11 = "BBBBBBBBBB";

    private static final String DEFAULT_INDICATOR_DISCUSS_12 = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_DISCUSS_12 = "BBBBBBBBBB";

    private static final String DEFAULT_DECISION = "AAAAAAAAAA";
    private static final String UPDATED_DECISION = "BBBBBBBBBB";

    private static final String DEFAULT_POTENTIAL_MITIGATING_ACTIONS = "AAAAAAAAAA";
    private static final String UPDATED_POTENTIAL_MITIGATING_ACTIONS = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENT_CHALLENGE = "AAAAAAAAAA";
    private static final String UPDATED_COMMENT_CHALLENGE = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENT_VALIDATE = "AAAAAAAAAA";
    private static final String UPDATED_COMMENT_VALIDATE = "BBBBBBBBBB";

    private static final String DEFAULT_ENTITY_INFO_RC = "AAAAAAAAAA";
    private static final String UPDATED_ENTITY_INFO_RC = "BBBBBBBBBB";

    private static final String DEFAULT_STEP_IN_ESTIMATION_RC = "AAAAAAAAAA";
    private static final String UPDATED_STEP_IN_ESTIMATION_RC = "BBBBBBBBBB";

    private static final String DEFAULT_IMPACT_ANALYSIS_RC = "AAAAAAAAAA";
    private static final String UPDATED_IMPACT_ANALYSIS_RC = "BBBBBBBBBB";

    private static final String DEFAULT_INDICATOR_ANALYSIS_RC = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_ANALYSIS_RC = "BBBBBBBBBB";

    private static final String DEFAULT_ENTITY_BELOW_B_SPONSOR = "AAAAAAAAAA";
    private static final String UPDATED_ENTITY_BELOW_B_SPONSOR = "BBBBBBBBBB";

    private static final String DEFAULT_IS_SPE = "AAAAAAAAAA";
    private static final String UPDATED_IS_SPE = "BBBBBBBBBB";

    private static final String DEFAULT_NONE_OF_THE_ABOVE_A = "AAAAAAAAAA";
    private static final String UPDATED_NONE_OF_THE_ABOVE_A = "BBBBBBBBBB";

    private static final String DEFAULT_ENTITY_BELOW_B_INVESTOR = "AAAAAAAAAA";
    private static final String UPDATED_ENTITY_BELOW_B_INVESTOR = "BBBBBBBBBB";

    private static final String DEFAULT_EQUITY_HOLDINGS_PER_POLICY = "AAAAAAAAAA";
    private static final String UPDATED_EQUITY_HOLDINGS_PER_POLICY = "BBBBBBBBBB";

    private static final String DEFAULT_DEBT_HOLDINGS_IN_SCOPE = "AAAAAAAAAA";
    private static final String UPDATED_DEBT_HOLDINGS_IN_SCOPE = "BBBBBBBBBB";

    private static final String DEFAULT_NONE_OF_THE_ABOVE_B = "AAAAAAAAAA";
    private static final String UPDATED_NONE_OF_THE_ABOVE_B = "BBBBBBBBBB";

    private static final String DEFAULT_TIER_1_VENDOR = "AAAAAAAAAA";
    private static final String UPDATED_TIER_1_VENDOR = "BBBBBBBBBB";

    private static final String DEFAULT_NONE_OF_THE_ABOVE_C = "AAAAAAAAAA";
    private static final String UPDATED_NONE_OF_THE_ABOVE_C = "BBBBBBBBBB";

    private static final String DEFAULT_ENTITY_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ENTITY_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_ENTITY_TYPE_OTHER = "AAAAAAAAAA";
    private static final String UPDATED_ENTITY_TYPE_OTHER = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT_NO_CID = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT_NO_CID = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE_OF_SUPPORT_ANTICIPATED = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_OF_SUPPORT_ANTICIPATED = "BBBBBBBBBB";

    private static final String DEFAULT_INSTRUMENT_OF_TRADING_OR_BANKING_BOOK = "AAAAAAAAAA";
    private static final String UPDATED_INSTRUMENT_OF_TRADING_OR_BANKING_BOOK = "BBBBBBBBBB";

    private static final String DEFAULT_REG_TREATMENT = "AAAAAAAAAA";
    private static final String UPDATED_REG_TREATMENT = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_ACCOUNTING_IFRS_TREATMENT = "AAAAAAAAAA";
    private static final String UPDATED_ACCOUNTING_IFRS_TREATMENT = "BBBBBBBBBB";

    private static final String DEFAULT_ACCOUNTING_IFRS_TREATMENT_EQUITY = "AAAAAAAAAA";
    private static final String UPDATED_ACCOUNTING_IFRS_TREATMENT_EQUITY = "BBBBBBBBBB";

    private static final String DEFAULT_ACCOUNTING_IFRS_TREATMENT_DEBT = "AAAAAAAAAA";
    private static final String UPDATED_ACCOUNTING_IFRS_TREATMENT_DEBT = "BBBBBBBBBB";

    private static final String DEFAULT_TOTAL_ASSET_SIZE = "AAAAAAAAAA";
    private static final String UPDATED_TOTAL_ASSET_SIZE = "BBBBBBBBBB";

    private static final String DEFAULT_UNCALLED_COMMITMENT = "AAAAAAAAAA";
    private static final String UPDATED_UNCALLED_COMMITMENT = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENT_AUM = "AAAAAAAAAA";
    private static final String UPDATED_CURRENT_AUM = "BBBBBBBBBB";

    private static final String DEFAULT_TARGET_AUM = "AAAAAAAAAA";
    private static final String UPDATED_TARGET_AUM = "BBBBBBBBBB";

    private static final String DEFAULT_STEP_IN_RISK_AMOUNT = "AAAAAAAAAA";
    private static final String UPDATED_STEP_IN_RISK_AMOUNT = "BBBBBBBBBB";

    private static final String DEFAULT_CONTRACTUAL_EXPOSURE_IN_MILLION_USD = "AAAAAAAAAA";
    private static final String UPDATED_CONTRACTUAL_EXPOSURE_IN_MILLION_USD = "BBBBBBBBBB";

    private static final String DEFAULT_AMCONF_1 = "AAAAAAAAAA";
    private static final String UPDATED_AMCONF_1 = "BBBBBBBBBB";

    private static final String DEFAULT_AMCONF_2 = "AAAAAAAAAA";
    private static final String UPDATED_AMCONF_2 = "BBBBBBBBBB";

    private static final String DEFAULT_AMCONF_3 = "AAAAAAAAAA";
    private static final String UPDATED_AMCONF_3 = "BBBBBBBBBB";

    private static final String DEFAULT_D_R_RDECISION = "AAAAAAAAAA";
    private static final String UPDATED_D_R_RDECISION = "BBBBBBBBBB";

    private static final String DEFAULT_OPTIONAL_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_OPTIONAL_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_OPTIONAL_COMMENT_RATIOS = "AAAAAAAAAA";
    private static final String UPDATED_OPTIONAL_COMMENT_RATIOS = "BBBBBBBBBB";

    private static final String DEFAULT_REJECTION_RATIONALE = "AAAAAAAAAA";
    private static final String UPDATED_REJECTION_RATIONALE = "BBBBBBBBBB";

    private static final String DEFAULT_DUE_DATE = "AAAAAAAAAA";
    private static final String UPDATED_DUE_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_CASE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CASE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CASE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CASE_NAME = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_END_TIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_END_TIME = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_CASE_DUE_DATE = "AAAAAAAAAA";
    private static final String UPDATED_CASE_DUE_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_FIRST_LO_D_INITIATOR = "AAAAAAAAAA";
    private static final String UPDATED_FIRST_LO_D_INITIATOR = "BBBBBBBBBB";

    private static final String DEFAULT_SECOND_LO_D_ASSIGNEE = "AAAAAAAAAA";
    private static final String UPDATED_SECOND_LO_D_ASSIGNEE = "BBBBBBBBBB";

    private static final String DEFAULT_RATIO_ASSIGNEE = "AAAAAAAAAA";
    private static final String UPDATED_RATIO_ASSIGNEE = "BBBBBBBBBB";

    private static final String DEFAULT_DRR_ASSIGNEE = "AAAAAAAAAA";
    private static final String UPDATED_DRR_ASSIGNEE = "BBBBBBBBBB";

    private static final String DEFAULT_BUSINESS_KEY = "AAAAAAAAAA";
    private static final String UPDATED_BUSINESS_KEY = "BBBBBBBBBB";

    private static final String DEFAULT_INITIATION_DATE = "AAAAAAAAAA";
    private static final String UPDATED_INITIATION_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_REVIEW_OUTCOME = "AAAAAAAAAA";
    private static final String UPDATED_REVIEW_OUTCOME = "BBBBBBBBBB";

    private static final String DEFAULT_UBS_DIVISION = "AAAAAAAAAA";
    private static final String UPDATED_UBS_DIVISION = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENT_REJECT = "AAAAAAAAAA";
    private static final String UPDATED_COMMENT_REJECT = "BBBBBBBBBB";

    private static final String DEFAULT_REJECT_OR_ESCALATE = "AAAAAAAAAA";
    private static final String UPDATED_REJECT_OR_ESCALATE = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT_ESCALATION = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT_ESCALATION = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT_ESCALATION_NO_CID = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT_ESCALATION_NO_CID = "BBBBBBBBBB";

    private static final String DEFAULT_CALLBACK_ID = "AAAAAAAAAA";
    private static final String UPDATED_CALLBACK_ID = "BBBBBBBBBB";

    private static final String DEFAULT_CALLBACK_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CALLBACK_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CASE_DEFINITION_ID = "AAAAAAAAAA";
    private static final String UPDATED_CASE_DEFINITION_ID = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_ID = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_ID = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_START_TIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_START_TIME = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_START_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_START_USER_ID = "BBBBBBBBBB";

    private static final String DEFAULT_STATE = "AAAAAAAAAA";
    private static final String UPDATED_STATE = "BBBBBBBBBB";

    private static final String DEFAULT_TENANT_ID = "AAAAAAAAAA";
    private static final String UPDATED_TENANT_ID = "BBBBBBBBBB";

    @Autowired
    private STIRCaseRepository sTIRCaseRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restSTIRCaseMockMvc;

    private STIRCase sTIRCase;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final STIRCaseResource sTIRCaseResource = new STIRCaseResource(sTIRCaseRepository);
        this.restSTIRCaseMockMvc = MockMvcBuilders.standaloneSetup(sTIRCaseResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static STIRCase createEntity(EntityManager em) {
        STIRCase sTIRCase = new STIRCase()
            .entityName(DEFAULT_ENTITY_NAME)
            .entity(DEFAULT_ENTITY)
            .lsdbID(DEFAULT_LSDB_ID)
            .relationship(DEFAULT_RELATIONSHIP)
            .vendorRAGstatus(DEFAULT_VENDOR_RA_GSTATUS)
            .explanationOfEstimate(DEFAULT_EXPLANATION_OF_ESTIMATE)
            .repRiskConcerns(DEFAULT_REP_RISK_CONCERNS)
            .relationshipDescription(DEFAULT_RELATIONSHIP_DESCRIPTION)
            .i1na(DEFAULT_I_1_NA)
            .i2na(DEFAULT_I_2_NA)
            .i3na(DEFAULT_I_3_NA)
            .i4na(DEFAULT_I_4_NA)
            .i5na(DEFAULT_I_5_NA)
            .i6na(DEFAULT_I_6_NA)
            .i7na(DEFAULT_I_7_NA)
            .i8na(DEFAULT_I_8_NA)
            .i9na(DEFAULT_I_9_NA)
            .i10na(DEFAULT_I_10_NA)
            .i11na(DEFAULT_I_11_NA)
            .i12na(DEFAULT_I_12_NA)
            .indicatorDiscuss1(DEFAULT_INDICATOR_DISCUSS_1)
            .indicatorDiscuss2(DEFAULT_INDICATOR_DISCUSS_2)
            .indicatorDiscuss3(DEFAULT_INDICATOR_DISCUSS_3)
            .indicatorDiscuss4(DEFAULT_INDICATOR_DISCUSS_4)
            .indicatorDiscuss5(DEFAULT_INDICATOR_DISCUSS_5)
            .indicatorDiscuss6(DEFAULT_INDICATOR_DISCUSS_6)
            .indicatorDiscuss7(DEFAULT_INDICATOR_DISCUSS_7)
            .indicatorDiscuss8(DEFAULT_INDICATOR_DISCUSS_8)
            .indicatorDiscuss9(DEFAULT_INDICATOR_DISCUSS_9)
            .indicatorDiscuss10(DEFAULT_INDICATOR_DISCUSS_10)
            .indicatorDiscuss11(DEFAULT_INDICATOR_DISCUSS_11)
            .indicatorDiscuss12(DEFAULT_INDICATOR_DISCUSS_12)
            .decision(DEFAULT_DECISION)
            .potentialMitigatingActions(DEFAULT_POTENTIAL_MITIGATING_ACTIONS)
            .commentChallenge(DEFAULT_COMMENT_CHALLENGE)
            .commentValidate(DEFAULT_COMMENT_VALIDATE)
            .entityInfoRC(DEFAULT_ENTITY_INFO_RC)
            .stepInEstimationRC(DEFAULT_STEP_IN_ESTIMATION_RC)
            .impactAnalysisRC(DEFAULT_IMPACT_ANALYSIS_RC)
            .indicatorAnalysisRC(DEFAULT_INDICATOR_ANALYSIS_RC)
            .entityBelowBSponsor(DEFAULT_ENTITY_BELOW_B_SPONSOR)
            .isSPE(DEFAULT_IS_SPE)
            .noneOfTheAboveA(DEFAULT_NONE_OF_THE_ABOVE_A)
            .entityBelowBInvestor(DEFAULT_ENTITY_BELOW_B_INVESTOR)
            .equityHoldingsPerPolicy(DEFAULT_EQUITY_HOLDINGS_PER_POLICY)
            .debtHoldingsInScope(DEFAULT_DEBT_HOLDINGS_IN_SCOPE)
            .noneOfTheAboveB(DEFAULT_NONE_OF_THE_ABOVE_B)
            .tier1Vendor(DEFAULT_TIER_1_VENDOR)
            .noneOfTheAboveC(DEFAULT_NONE_OF_THE_ABOVE_C)
            .entityType(DEFAULT_ENTITY_TYPE)
            .entityTypeOther(DEFAULT_ENTITY_TYPE_OTHER)
            .attachment(DEFAULT_ATTACHMENT)
            .attachmentNoCID(DEFAULT_ATTACHMENT_NO_CID)
            .attachmentComment(DEFAULT_ATTACHMENT_COMMENT)
            .typeOfSupportAnticipated(DEFAULT_TYPE_OF_SUPPORT_ANTICIPATED)
            .instrumentOfTradingOrBankingBook(DEFAULT_INSTRUMENT_OF_TRADING_OR_BANKING_BOOK)
            .regTreatment(DEFAULT_REG_TREATMENT)
            .description(DEFAULT_DESCRIPTION)
            .accountingIFRSTreatment(DEFAULT_ACCOUNTING_IFRS_TREATMENT)
            .accountingIFRSTreatmentEquity(DEFAULT_ACCOUNTING_IFRS_TREATMENT_EQUITY)
            .accountingIFRSTreatmentDebt(DEFAULT_ACCOUNTING_IFRS_TREATMENT_DEBT)
            .totalAssetSize(DEFAULT_TOTAL_ASSET_SIZE)
            .uncalledCommitment(DEFAULT_UNCALLED_COMMITMENT)
            .currentAUM(DEFAULT_CURRENT_AUM)
            .targetAUM(DEFAULT_TARGET_AUM)
            .stepInRiskAmount(DEFAULT_STEP_IN_RISK_AMOUNT)
            .contractualExposureInMillionUSD(DEFAULT_CONTRACTUAL_EXPOSURE_IN_MILLION_USD)
            .amconf1(DEFAULT_AMCONF_1)
            .amconf2(DEFAULT_AMCONF_2)
            .amconf3(DEFAULT_AMCONF_3)
            .dRRdecision(DEFAULT_D_R_RDECISION)
            .optionalComment(DEFAULT_OPTIONAL_COMMENT)
            .optionalCommentRatios(DEFAULT_OPTIONAL_COMMENT_RATIOS)
            .rejectionRationale(DEFAULT_REJECTION_RATIONALE)
            .dueDate(DEFAULT_DUE_DATE)
            .caseType(DEFAULT_CASE_TYPE)
            .caseName(DEFAULT_CASE_NAME)
            .endTime(DEFAULT_END_TIME)
            .caseDueDate(DEFAULT_CASE_DUE_DATE)
            .firstLoDInitiator(DEFAULT_FIRST_LO_D_INITIATOR)
            .secondLoDAssignee(DEFAULT_SECOND_LO_D_ASSIGNEE)
            .ratioAssignee(DEFAULT_RATIO_ASSIGNEE)
            .drrAssignee(DEFAULT_DRR_ASSIGNEE)
            .businessKey(DEFAULT_BUSINESS_KEY)
            .initiationDate(DEFAULT_INITIATION_DATE)
            .reviewOutcome(DEFAULT_REVIEW_OUTCOME)
            .ubsDivision(DEFAULT_UBS_DIVISION)
            .commentReject(DEFAULT_COMMENT_REJECT)
            .rejectOrEscalate(DEFAULT_REJECT_OR_ESCALATE)
            .attachmentEscalation(DEFAULT_ATTACHMENT_ESCALATION)
            .attachmentEscalationNoCID(DEFAULT_ATTACHMENT_ESCALATION_NO_CID)
            .callbackId(DEFAULT_CALLBACK_ID)
            .callbackType(DEFAULT_CALLBACK_TYPE)
            .caseDefinitionId(DEFAULT_CASE_DEFINITION_ID)
            .name(DEFAULT_NAME)
            .parentId(DEFAULT_PARENT_ID)
            .startTime(DEFAULT_START_TIME)
            .startUserId(DEFAULT_START_USER_ID)
            .state(DEFAULT_STATE)
            .tenantId(DEFAULT_TENANT_ID);
        return sTIRCase;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static STIRCase createUpdatedEntity(EntityManager em) {
        STIRCase sTIRCase = new STIRCase()
            .entityName(UPDATED_ENTITY_NAME)
            .entity(UPDATED_ENTITY)
            .lsdbID(UPDATED_LSDB_ID)
            .relationship(UPDATED_RELATIONSHIP)
            .vendorRAGstatus(UPDATED_VENDOR_RA_GSTATUS)
            .explanationOfEstimate(UPDATED_EXPLANATION_OF_ESTIMATE)
            .repRiskConcerns(UPDATED_REP_RISK_CONCERNS)
            .relationshipDescription(UPDATED_RELATIONSHIP_DESCRIPTION)
            .i1na(UPDATED_I_1_NA)
            .i2na(UPDATED_I_2_NA)
            .i3na(UPDATED_I_3_NA)
            .i4na(UPDATED_I_4_NA)
            .i5na(UPDATED_I_5_NA)
            .i6na(UPDATED_I_6_NA)
            .i7na(UPDATED_I_7_NA)
            .i8na(UPDATED_I_8_NA)
            .i9na(UPDATED_I_9_NA)
            .i10na(UPDATED_I_10_NA)
            .i11na(UPDATED_I_11_NA)
            .i12na(UPDATED_I_12_NA)
            .indicatorDiscuss1(UPDATED_INDICATOR_DISCUSS_1)
            .indicatorDiscuss2(UPDATED_INDICATOR_DISCUSS_2)
            .indicatorDiscuss3(UPDATED_INDICATOR_DISCUSS_3)
            .indicatorDiscuss4(UPDATED_INDICATOR_DISCUSS_4)
            .indicatorDiscuss5(UPDATED_INDICATOR_DISCUSS_5)
            .indicatorDiscuss6(UPDATED_INDICATOR_DISCUSS_6)
            .indicatorDiscuss7(UPDATED_INDICATOR_DISCUSS_7)
            .indicatorDiscuss8(UPDATED_INDICATOR_DISCUSS_8)
            .indicatorDiscuss9(UPDATED_INDICATOR_DISCUSS_9)
            .indicatorDiscuss10(UPDATED_INDICATOR_DISCUSS_10)
            .indicatorDiscuss11(UPDATED_INDICATOR_DISCUSS_11)
            .indicatorDiscuss12(UPDATED_INDICATOR_DISCUSS_12)
            .decision(UPDATED_DECISION)
            .potentialMitigatingActions(UPDATED_POTENTIAL_MITIGATING_ACTIONS)
            .commentChallenge(UPDATED_COMMENT_CHALLENGE)
            .commentValidate(UPDATED_COMMENT_VALIDATE)
            .entityInfoRC(UPDATED_ENTITY_INFO_RC)
            .stepInEstimationRC(UPDATED_STEP_IN_ESTIMATION_RC)
            .impactAnalysisRC(UPDATED_IMPACT_ANALYSIS_RC)
            .indicatorAnalysisRC(UPDATED_INDICATOR_ANALYSIS_RC)
            .entityBelowBSponsor(UPDATED_ENTITY_BELOW_B_SPONSOR)
            .isSPE(UPDATED_IS_SPE)
            .noneOfTheAboveA(UPDATED_NONE_OF_THE_ABOVE_A)
            .entityBelowBInvestor(UPDATED_ENTITY_BELOW_B_INVESTOR)
            .equityHoldingsPerPolicy(UPDATED_EQUITY_HOLDINGS_PER_POLICY)
            .debtHoldingsInScope(UPDATED_DEBT_HOLDINGS_IN_SCOPE)
            .noneOfTheAboveB(UPDATED_NONE_OF_THE_ABOVE_B)
            .tier1Vendor(UPDATED_TIER_1_VENDOR)
            .noneOfTheAboveC(UPDATED_NONE_OF_THE_ABOVE_C)
            .entityType(UPDATED_ENTITY_TYPE)
            .entityTypeOther(UPDATED_ENTITY_TYPE_OTHER)
            .attachment(UPDATED_ATTACHMENT)
            .attachmentNoCID(UPDATED_ATTACHMENT_NO_CID)
            .attachmentComment(UPDATED_ATTACHMENT_COMMENT)
            .typeOfSupportAnticipated(UPDATED_TYPE_OF_SUPPORT_ANTICIPATED)
            .instrumentOfTradingOrBankingBook(UPDATED_INSTRUMENT_OF_TRADING_OR_BANKING_BOOK)
            .regTreatment(UPDATED_REG_TREATMENT)
            .description(UPDATED_DESCRIPTION)
            .accountingIFRSTreatment(UPDATED_ACCOUNTING_IFRS_TREATMENT)
            .accountingIFRSTreatmentEquity(UPDATED_ACCOUNTING_IFRS_TREATMENT_EQUITY)
            .accountingIFRSTreatmentDebt(UPDATED_ACCOUNTING_IFRS_TREATMENT_DEBT)
            .totalAssetSize(UPDATED_TOTAL_ASSET_SIZE)
            .uncalledCommitment(UPDATED_UNCALLED_COMMITMENT)
            .currentAUM(UPDATED_CURRENT_AUM)
            .targetAUM(UPDATED_TARGET_AUM)
            .stepInRiskAmount(UPDATED_STEP_IN_RISK_AMOUNT)
            .contractualExposureInMillionUSD(UPDATED_CONTRACTUAL_EXPOSURE_IN_MILLION_USD)
            .amconf1(UPDATED_AMCONF_1)
            .amconf2(UPDATED_AMCONF_2)
            .amconf3(UPDATED_AMCONF_3)
            .dRRdecision(UPDATED_D_R_RDECISION)
            .optionalComment(UPDATED_OPTIONAL_COMMENT)
            .optionalCommentRatios(UPDATED_OPTIONAL_COMMENT_RATIOS)
            .rejectionRationale(UPDATED_REJECTION_RATIONALE)
            .dueDate(UPDATED_DUE_DATE)
            .caseType(UPDATED_CASE_TYPE)
            .caseName(UPDATED_CASE_NAME)
            .endTime(UPDATED_END_TIME)
            .caseDueDate(UPDATED_CASE_DUE_DATE)
            .firstLoDInitiator(UPDATED_FIRST_LO_D_INITIATOR)
            .secondLoDAssignee(UPDATED_SECOND_LO_D_ASSIGNEE)
            .ratioAssignee(UPDATED_RATIO_ASSIGNEE)
            .drrAssignee(UPDATED_DRR_ASSIGNEE)
            .businessKey(UPDATED_BUSINESS_KEY)
            .initiationDate(UPDATED_INITIATION_DATE)
            .reviewOutcome(UPDATED_REVIEW_OUTCOME)
            .ubsDivision(UPDATED_UBS_DIVISION)
            .commentReject(UPDATED_COMMENT_REJECT)
            .rejectOrEscalate(UPDATED_REJECT_OR_ESCALATE)
            .attachmentEscalation(UPDATED_ATTACHMENT_ESCALATION)
            .attachmentEscalationNoCID(UPDATED_ATTACHMENT_ESCALATION_NO_CID)
            .callbackId(UPDATED_CALLBACK_ID)
            .callbackType(UPDATED_CALLBACK_TYPE)
            .caseDefinitionId(UPDATED_CASE_DEFINITION_ID)
            .name(UPDATED_NAME)
            .parentId(UPDATED_PARENT_ID)
            .startTime(UPDATED_START_TIME)
            .startUserId(UPDATED_START_USER_ID)
            .state(UPDATED_STATE)
            .tenantId(UPDATED_TENANT_ID);
        return sTIRCase;
    }

    @BeforeEach
    public void initTest() {
        sTIRCase = createEntity(em);
    }

    @Test
    @Transactional
    public void createSTIRCase() throws Exception {
        int databaseSizeBeforeCreate = sTIRCaseRepository.findAll().size();

        // Create the STIRCase
        restSTIRCaseMockMvc.perform(post("/api/stir-cases")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sTIRCase)))
            .andExpect(status().isCreated());

        // Validate the STIRCase in the database
        List<STIRCase> sTIRCaseList = sTIRCaseRepository.findAll();
        assertThat(sTIRCaseList).hasSize(databaseSizeBeforeCreate + 1);
        STIRCase testSTIRCase = sTIRCaseList.get(sTIRCaseList.size() - 1);
        assertThat(testSTIRCase.getEntityName()).isEqualTo(DEFAULT_ENTITY_NAME);
        assertThat(testSTIRCase.getEntity()).isEqualTo(DEFAULT_ENTITY);
        assertThat(testSTIRCase.getLsdbID()).isEqualTo(DEFAULT_LSDB_ID);
        assertThat(testSTIRCase.getRelationship()).isEqualTo(DEFAULT_RELATIONSHIP);
        assertThat(testSTIRCase.getVendorRAGstatus()).isEqualTo(DEFAULT_VENDOR_RA_GSTATUS);
        assertThat(testSTIRCase.getExplanationOfEstimate()).isEqualTo(DEFAULT_EXPLANATION_OF_ESTIMATE);
        assertThat(testSTIRCase.getRepRiskConcerns()).isEqualTo(DEFAULT_REP_RISK_CONCERNS);
        assertThat(testSTIRCase.getRelationshipDescription()).isEqualTo(DEFAULT_RELATIONSHIP_DESCRIPTION);
        assertThat(testSTIRCase.geti1na()).isEqualTo(DEFAULT_I_1_NA);
        assertThat(testSTIRCase.geti2na()).isEqualTo(DEFAULT_I_2_NA);
        assertThat(testSTIRCase.geti3na()).isEqualTo(DEFAULT_I_3_NA);
        assertThat(testSTIRCase.geti4na()).isEqualTo(DEFAULT_I_4_NA);
        assertThat(testSTIRCase.geti5na()).isEqualTo(DEFAULT_I_5_NA);
        assertThat(testSTIRCase.geti6na()).isEqualTo(DEFAULT_I_6_NA);
        assertThat(testSTIRCase.geti7na()).isEqualTo(DEFAULT_I_7_NA);
        assertThat(testSTIRCase.geti8na()).isEqualTo(DEFAULT_I_8_NA);
        assertThat(testSTIRCase.geti9na()).isEqualTo(DEFAULT_I_9_NA);
        assertThat(testSTIRCase.geti10na()).isEqualTo(DEFAULT_I_10_NA);
        assertThat(testSTIRCase.geti11na()).isEqualTo(DEFAULT_I_11_NA);
        assertThat(testSTIRCase.geti12na()).isEqualTo(DEFAULT_I_12_NA);
        assertThat(testSTIRCase.getIndicatorDiscuss1()).isEqualTo(DEFAULT_INDICATOR_DISCUSS_1);
        assertThat(testSTIRCase.getIndicatorDiscuss2()).isEqualTo(DEFAULT_INDICATOR_DISCUSS_2);
        assertThat(testSTIRCase.getIndicatorDiscuss3()).isEqualTo(DEFAULT_INDICATOR_DISCUSS_3);
        assertThat(testSTIRCase.getIndicatorDiscuss4()).isEqualTo(DEFAULT_INDICATOR_DISCUSS_4);
        assertThat(testSTIRCase.getIndicatorDiscuss5()).isEqualTo(DEFAULT_INDICATOR_DISCUSS_5);
        assertThat(testSTIRCase.getIndicatorDiscuss6()).isEqualTo(DEFAULT_INDICATOR_DISCUSS_6);
        assertThat(testSTIRCase.getIndicatorDiscuss7()).isEqualTo(DEFAULT_INDICATOR_DISCUSS_7);
        assertThat(testSTIRCase.getIndicatorDiscuss8()).isEqualTo(DEFAULT_INDICATOR_DISCUSS_8);
        assertThat(testSTIRCase.getIndicatorDiscuss9()).isEqualTo(DEFAULT_INDICATOR_DISCUSS_9);
        assertThat(testSTIRCase.getIndicatorDiscuss10()).isEqualTo(DEFAULT_INDICATOR_DISCUSS_10);
        assertThat(testSTIRCase.getIndicatorDiscuss11()).isEqualTo(DEFAULT_INDICATOR_DISCUSS_11);
        assertThat(testSTIRCase.getIndicatorDiscuss12()).isEqualTo(DEFAULT_INDICATOR_DISCUSS_12);
        assertThat(testSTIRCase.getDecision()).isEqualTo(DEFAULT_DECISION);
        assertThat(testSTIRCase.getPotentialMitigatingActions()).isEqualTo(DEFAULT_POTENTIAL_MITIGATING_ACTIONS);
        assertThat(testSTIRCase.getCommentChallenge()).isEqualTo(DEFAULT_COMMENT_CHALLENGE);
        assertThat(testSTIRCase.getCommentValidate()).isEqualTo(DEFAULT_COMMENT_VALIDATE);
        assertThat(testSTIRCase.getEntityInfoRC()).isEqualTo(DEFAULT_ENTITY_INFO_RC);
        assertThat(testSTIRCase.getStepInEstimationRC()).isEqualTo(DEFAULT_STEP_IN_ESTIMATION_RC);
        assertThat(testSTIRCase.getImpactAnalysisRC()).isEqualTo(DEFAULT_IMPACT_ANALYSIS_RC);
        assertThat(testSTIRCase.getIndicatorAnalysisRC()).isEqualTo(DEFAULT_INDICATOR_ANALYSIS_RC);
        assertThat(testSTIRCase.getEntityBelowBSponsor()).isEqualTo(DEFAULT_ENTITY_BELOW_B_SPONSOR);
        assertThat(testSTIRCase.getIsSPE()).isEqualTo(DEFAULT_IS_SPE);
        assertThat(testSTIRCase.getNoneOfTheAboveA()).isEqualTo(DEFAULT_NONE_OF_THE_ABOVE_A);
        assertThat(testSTIRCase.getEntityBelowBInvestor()).isEqualTo(DEFAULT_ENTITY_BELOW_B_INVESTOR);
        assertThat(testSTIRCase.getEquityHoldingsPerPolicy()).isEqualTo(DEFAULT_EQUITY_HOLDINGS_PER_POLICY);
        assertThat(testSTIRCase.getDebtHoldingsInScope()).isEqualTo(DEFAULT_DEBT_HOLDINGS_IN_SCOPE);
        assertThat(testSTIRCase.getNoneOfTheAboveB()).isEqualTo(DEFAULT_NONE_OF_THE_ABOVE_B);
        assertThat(testSTIRCase.getTier1Vendor()).isEqualTo(DEFAULT_TIER_1_VENDOR);
        assertThat(testSTIRCase.getNoneOfTheAboveC()).isEqualTo(DEFAULT_NONE_OF_THE_ABOVE_C);
        assertThat(testSTIRCase.getEntityType()).isEqualTo(DEFAULT_ENTITY_TYPE);
        assertThat(testSTIRCase.getEntityTypeOther()).isEqualTo(DEFAULT_ENTITY_TYPE_OTHER);
        assertThat(testSTIRCase.getAttachment()).isEqualTo(DEFAULT_ATTACHMENT);
        assertThat(testSTIRCase.getAttachmentNoCID()).isEqualTo(DEFAULT_ATTACHMENT_NO_CID);
        assertThat(testSTIRCase.getAttachmentComment()).isEqualTo(DEFAULT_ATTACHMENT_COMMENT);
        assertThat(testSTIRCase.getTypeOfSupportAnticipated()).isEqualTo(DEFAULT_TYPE_OF_SUPPORT_ANTICIPATED);
        assertThat(testSTIRCase.getInstrumentOfTradingOrBankingBook()).isEqualTo(DEFAULT_INSTRUMENT_OF_TRADING_OR_BANKING_BOOK);
        assertThat(testSTIRCase.getRegTreatment()).isEqualTo(DEFAULT_REG_TREATMENT);
        assertThat(testSTIRCase.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testSTIRCase.getAccountingIFRSTreatment()).isEqualTo(DEFAULT_ACCOUNTING_IFRS_TREATMENT);
        assertThat(testSTIRCase.getAccountingIFRSTreatmentEquity()).isEqualTo(DEFAULT_ACCOUNTING_IFRS_TREATMENT_EQUITY);
        assertThat(testSTIRCase.getAccountingIFRSTreatmentDebt()).isEqualTo(DEFAULT_ACCOUNTING_IFRS_TREATMENT_DEBT);
        assertThat(testSTIRCase.getTotalAssetSize()).isEqualTo(DEFAULT_TOTAL_ASSET_SIZE);
        assertThat(testSTIRCase.getUncalledCommitment()).isEqualTo(DEFAULT_UNCALLED_COMMITMENT);
        assertThat(testSTIRCase.getCurrentAUM()).isEqualTo(DEFAULT_CURRENT_AUM);
        assertThat(testSTIRCase.getTargetAUM()).isEqualTo(DEFAULT_TARGET_AUM);
        assertThat(testSTIRCase.getStepInRiskAmount()).isEqualTo(DEFAULT_STEP_IN_RISK_AMOUNT);
        assertThat(testSTIRCase.getContractualExposureInMillionUSD()).isEqualTo(DEFAULT_CONTRACTUAL_EXPOSURE_IN_MILLION_USD);
        assertThat(testSTIRCase.getAmconf1()).isEqualTo(DEFAULT_AMCONF_1);
        assertThat(testSTIRCase.getAmconf2()).isEqualTo(DEFAULT_AMCONF_2);
        assertThat(testSTIRCase.getAmconf3()).isEqualTo(DEFAULT_AMCONF_3);
        assertThat(testSTIRCase.getdRRdecision()).isEqualTo(DEFAULT_D_R_RDECISION);
        assertThat(testSTIRCase.getOptionalComment()).isEqualTo(DEFAULT_OPTIONAL_COMMENT);
        assertThat(testSTIRCase.getOptionalCommentRatios()).isEqualTo(DEFAULT_OPTIONAL_COMMENT_RATIOS);
        assertThat(testSTIRCase.getRejectionRationale()).isEqualTo(DEFAULT_REJECTION_RATIONALE);
        assertThat(testSTIRCase.getDueDate()).isEqualTo(DEFAULT_DUE_DATE);
        assertThat(testSTIRCase.getCaseType()).isEqualTo(DEFAULT_CASE_TYPE);
        assertThat(testSTIRCase.getCaseName()).isEqualTo(DEFAULT_CASE_NAME);
        assertThat(testSTIRCase.getEndTime()).isEqualTo(DEFAULT_END_TIME);
        assertThat(testSTIRCase.getCaseDueDate()).isEqualTo(DEFAULT_CASE_DUE_DATE);
        assertThat(testSTIRCase.getFirstLoDInitiator()).isEqualTo(DEFAULT_FIRST_LO_D_INITIATOR);
        assertThat(testSTIRCase.getSecondLoDAssignee()).isEqualTo(DEFAULT_SECOND_LO_D_ASSIGNEE);
        assertThat(testSTIRCase.getRatioAssignee()).isEqualTo(DEFAULT_RATIO_ASSIGNEE);
        assertThat(testSTIRCase.getDrrAssignee()).isEqualTo(DEFAULT_DRR_ASSIGNEE);
        assertThat(testSTIRCase.getBusinessKey()).isEqualTo(DEFAULT_BUSINESS_KEY);
        assertThat(testSTIRCase.getInitiationDate()).isEqualTo(DEFAULT_INITIATION_DATE);
        assertThat(testSTIRCase.getReviewOutcome()).isEqualTo(DEFAULT_REVIEW_OUTCOME);
        assertThat(testSTIRCase.getUbsDivision()).isEqualTo(DEFAULT_UBS_DIVISION);
        assertThat(testSTIRCase.getCommentReject()).isEqualTo(DEFAULT_COMMENT_REJECT);
        assertThat(testSTIRCase.getRejectOrEscalate()).isEqualTo(DEFAULT_REJECT_OR_ESCALATE);
        assertThat(testSTIRCase.getAttachmentEscalation()).isEqualTo(DEFAULT_ATTACHMENT_ESCALATION);
        assertThat(testSTIRCase.getAttachmentEscalationNoCID()).isEqualTo(DEFAULT_ATTACHMENT_ESCALATION_NO_CID);
        assertThat(testSTIRCase.getCallbackId()).isEqualTo(DEFAULT_CALLBACK_ID);
        assertThat(testSTIRCase.getCallbackType()).isEqualTo(DEFAULT_CALLBACK_TYPE);
        assertThat(testSTIRCase.getCaseDefinitionId()).isEqualTo(DEFAULT_CASE_DEFINITION_ID);
        assertThat(testSTIRCase.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testSTIRCase.getParentId()).isEqualTo(DEFAULT_PARENT_ID);
        assertThat(testSTIRCase.getStartTime()).isEqualTo(DEFAULT_START_TIME);
        assertThat(testSTIRCase.getStartUserId()).isEqualTo(DEFAULT_START_USER_ID);
        assertThat(testSTIRCase.getState()).isEqualTo(DEFAULT_STATE);
        assertThat(testSTIRCase.getTenantId()).isEqualTo(DEFAULT_TENANT_ID);
    }

    @Test
    @Transactional
    public void createSTIRCaseWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sTIRCaseRepository.findAll().size();

        // Create the STIRCase with an existing ID
        sTIRCase.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSTIRCaseMockMvc.perform(post("/api/stir-cases")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sTIRCase)))
            .andExpect(status().isBadRequest());

        // Validate the STIRCase in the database
        List<STIRCase> sTIRCaseList = sTIRCaseRepository.findAll();
        assertThat(sTIRCaseList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSTIRCases() throws Exception {
        // Initialize the database
        sTIRCaseRepository.saveAndFlush(sTIRCase);

        // Get all the sTIRCaseList
        restSTIRCaseMockMvc.perform(get("/api/stir-cases?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sTIRCase.getId().intValue())))
            .andExpect(jsonPath("$.[*].entityName").value(hasItem(DEFAULT_ENTITY_NAME)))
            .andExpect(jsonPath("$.[*].entity").value(hasItem(DEFAULT_ENTITY)))
            .andExpect(jsonPath("$.[*].lsdbID").value(hasItem(DEFAULT_LSDB_ID)))
            .andExpect(jsonPath("$.[*].relationship").value(hasItem(DEFAULT_RELATIONSHIP)))
            .andExpect(jsonPath("$.[*].vendorRAGstatus").value(hasItem(DEFAULT_VENDOR_RA_GSTATUS)))
            .andExpect(jsonPath("$.[*].explanationOfEstimate").value(hasItem(DEFAULT_EXPLANATION_OF_ESTIMATE)))
            .andExpect(jsonPath("$.[*].repRiskConcerns").value(hasItem(DEFAULT_REP_RISK_CONCERNS)))
            .andExpect(jsonPath("$.[*].relationshipDescription").value(hasItem(DEFAULT_RELATIONSHIP_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].i1na").value(hasItem(DEFAULT_I_1_NA)))
            .andExpect(jsonPath("$.[*].i2na").value(hasItem(DEFAULT_I_2_NA)))
            .andExpect(jsonPath("$.[*].i3na").value(hasItem(DEFAULT_I_3_NA)))
            .andExpect(jsonPath("$.[*].i4na").value(hasItem(DEFAULT_I_4_NA)))
            .andExpect(jsonPath("$.[*].i5na").value(hasItem(DEFAULT_I_5_NA)))
            .andExpect(jsonPath("$.[*].i6na").value(hasItem(DEFAULT_I_6_NA)))
            .andExpect(jsonPath("$.[*].i7na").value(hasItem(DEFAULT_I_7_NA)))
            .andExpect(jsonPath("$.[*].i8na").value(hasItem(DEFAULT_I_8_NA)))
            .andExpect(jsonPath("$.[*].i9na").value(hasItem(DEFAULT_I_9_NA)))
            .andExpect(jsonPath("$.[*].i10na").value(hasItem(DEFAULT_I_10_NA)))
            .andExpect(jsonPath("$.[*].i11na").value(hasItem(DEFAULT_I_11_NA)))
            .andExpect(jsonPath("$.[*].i12na").value(hasItem(DEFAULT_I_12_NA)))
            .andExpect(jsonPath("$.[*].indicatorDiscuss1").value(hasItem(DEFAULT_INDICATOR_DISCUSS_1)))
            .andExpect(jsonPath("$.[*].indicatorDiscuss2").value(hasItem(DEFAULT_INDICATOR_DISCUSS_2)))
            .andExpect(jsonPath("$.[*].indicatorDiscuss3").value(hasItem(DEFAULT_INDICATOR_DISCUSS_3)))
            .andExpect(jsonPath("$.[*].indicatorDiscuss4").value(hasItem(DEFAULT_INDICATOR_DISCUSS_4)))
            .andExpect(jsonPath("$.[*].indicatorDiscuss5").value(hasItem(DEFAULT_INDICATOR_DISCUSS_5)))
            .andExpect(jsonPath("$.[*].indicatorDiscuss6").value(hasItem(DEFAULT_INDICATOR_DISCUSS_6)))
            .andExpect(jsonPath("$.[*].indicatorDiscuss7").value(hasItem(DEFAULT_INDICATOR_DISCUSS_7)))
            .andExpect(jsonPath("$.[*].indicatorDiscuss8").value(hasItem(DEFAULT_INDICATOR_DISCUSS_8)))
            .andExpect(jsonPath("$.[*].indicatorDiscuss9").value(hasItem(DEFAULT_INDICATOR_DISCUSS_9)))
            .andExpect(jsonPath("$.[*].indicatorDiscuss10").value(hasItem(DEFAULT_INDICATOR_DISCUSS_10)))
            .andExpect(jsonPath("$.[*].indicatorDiscuss11").value(hasItem(DEFAULT_INDICATOR_DISCUSS_11)))
            .andExpect(jsonPath("$.[*].indicatorDiscuss12").value(hasItem(DEFAULT_INDICATOR_DISCUSS_12)))
            .andExpect(jsonPath("$.[*].decision").value(hasItem(DEFAULT_DECISION)))
            .andExpect(jsonPath("$.[*].potentialMitigatingActions").value(hasItem(DEFAULT_POTENTIAL_MITIGATING_ACTIONS)))
            .andExpect(jsonPath("$.[*].commentChallenge").value(hasItem(DEFAULT_COMMENT_CHALLENGE)))
            .andExpect(jsonPath("$.[*].commentValidate").value(hasItem(DEFAULT_COMMENT_VALIDATE)))
            .andExpect(jsonPath("$.[*].entityInfoRC").value(hasItem(DEFAULT_ENTITY_INFO_RC)))
            .andExpect(jsonPath("$.[*].stepInEstimationRC").value(hasItem(DEFAULT_STEP_IN_ESTIMATION_RC)))
            .andExpect(jsonPath("$.[*].impactAnalysisRC").value(hasItem(DEFAULT_IMPACT_ANALYSIS_RC)))
            .andExpect(jsonPath("$.[*].indicatorAnalysisRC").value(hasItem(DEFAULT_INDICATOR_ANALYSIS_RC)))
            .andExpect(jsonPath("$.[*].entityBelowBSponsor").value(hasItem(DEFAULT_ENTITY_BELOW_B_SPONSOR)))
            .andExpect(jsonPath("$.[*].isSPE").value(hasItem(DEFAULT_IS_SPE)))
            .andExpect(jsonPath("$.[*].noneOfTheAboveA").value(hasItem(DEFAULT_NONE_OF_THE_ABOVE_A)))
            .andExpect(jsonPath("$.[*].entityBelowBInvestor").value(hasItem(DEFAULT_ENTITY_BELOW_B_INVESTOR)))
            .andExpect(jsonPath("$.[*].equityHoldingsPerPolicy").value(hasItem(DEFAULT_EQUITY_HOLDINGS_PER_POLICY)))
            .andExpect(jsonPath("$.[*].debtHoldingsInScope").value(hasItem(DEFAULT_DEBT_HOLDINGS_IN_SCOPE)))
            .andExpect(jsonPath("$.[*].noneOfTheAboveB").value(hasItem(DEFAULT_NONE_OF_THE_ABOVE_B)))
            .andExpect(jsonPath("$.[*].tier1Vendor").value(hasItem(DEFAULT_TIER_1_VENDOR)))
            .andExpect(jsonPath("$.[*].noneOfTheAboveC").value(hasItem(DEFAULT_NONE_OF_THE_ABOVE_C)))
            .andExpect(jsonPath("$.[*].entityType").value(hasItem(DEFAULT_ENTITY_TYPE)))
            .andExpect(jsonPath("$.[*].entityTypeOther").value(hasItem(DEFAULT_ENTITY_TYPE_OTHER)))
            .andExpect(jsonPath("$.[*].attachment").value(hasItem(DEFAULT_ATTACHMENT)))
            .andExpect(jsonPath("$.[*].attachmentNoCID").value(hasItem(DEFAULT_ATTACHMENT_NO_CID)))
            .andExpect(jsonPath("$.[*].attachmentComment").value(hasItem(DEFAULT_ATTACHMENT_COMMENT)))
            .andExpect(jsonPath("$.[*].typeOfSupportAnticipated").value(hasItem(DEFAULT_TYPE_OF_SUPPORT_ANTICIPATED)))
            .andExpect(jsonPath("$.[*].instrumentOfTradingOrBankingBook").value(hasItem(DEFAULT_INSTRUMENT_OF_TRADING_OR_BANKING_BOOK)))
            .andExpect(jsonPath("$.[*].regTreatment").value(hasItem(DEFAULT_REG_TREATMENT)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].accountingIFRSTreatment").value(hasItem(DEFAULT_ACCOUNTING_IFRS_TREATMENT)))
            .andExpect(jsonPath("$.[*].accountingIFRSTreatmentEquity").value(hasItem(DEFAULT_ACCOUNTING_IFRS_TREATMENT_EQUITY)))
            .andExpect(jsonPath("$.[*].accountingIFRSTreatmentDebt").value(hasItem(DEFAULT_ACCOUNTING_IFRS_TREATMENT_DEBT)))
            .andExpect(jsonPath("$.[*].totalAssetSize").value(hasItem(DEFAULT_TOTAL_ASSET_SIZE)))
            .andExpect(jsonPath("$.[*].uncalledCommitment").value(hasItem(DEFAULT_UNCALLED_COMMITMENT)))
            .andExpect(jsonPath("$.[*].currentAUM").value(hasItem(DEFAULT_CURRENT_AUM)))
            .andExpect(jsonPath("$.[*].targetAUM").value(hasItem(DEFAULT_TARGET_AUM)))
            .andExpect(jsonPath("$.[*].stepInRiskAmount").value(hasItem(DEFAULT_STEP_IN_RISK_AMOUNT)))
            .andExpect(jsonPath("$.[*].contractualExposureInMillionUSD").value(hasItem(DEFAULT_CONTRACTUAL_EXPOSURE_IN_MILLION_USD)))
            .andExpect(jsonPath("$.[*].amconf1").value(hasItem(DEFAULT_AMCONF_1)))
            .andExpect(jsonPath("$.[*].amconf2").value(hasItem(DEFAULT_AMCONF_2)))
            .andExpect(jsonPath("$.[*].amconf3").value(hasItem(DEFAULT_AMCONF_3)))
            .andExpect(jsonPath("$.[*].dRRdecision").value(hasItem(DEFAULT_D_R_RDECISION)))
            .andExpect(jsonPath("$.[*].optionalComment").value(hasItem(DEFAULT_OPTIONAL_COMMENT)))
            .andExpect(jsonPath("$.[*].optionalCommentRatios").value(hasItem(DEFAULT_OPTIONAL_COMMENT_RATIOS)))
            .andExpect(jsonPath("$.[*].rejectionRationale").value(hasItem(DEFAULT_REJECTION_RATIONALE)))
            .andExpect(jsonPath("$.[*].dueDate").value(hasItem(DEFAULT_DUE_DATE)))
            .andExpect(jsonPath("$.[*].caseType").value(hasItem(DEFAULT_CASE_TYPE)))
            .andExpect(jsonPath("$.[*].caseName").value(hasItem(DEFAULT_CASE_NAME)))
            .andExpect(jsonPath("$.[*].endTime").value(hasItem(DEFAULT_END_TIME.toString())))
            .andExpect(jsonPath("$.[*].caseDueDate").value(hasItem(DEFAULT_CASE_DUE_DATE)))
            .andExpect(jsonPath("$.[*].firstLoDInitiator").value(hasItem(DEFAULT_FIRST_LO_D_INITIATOR)))
            .andExpect(jsonPath("$.[*].secondLoDAssignee").value(hasItem(DEFAULT_SECOND_LO_D_ASSIGNEE)))
            .andExpect(jsonPath("$.[*].ratioAssignee").value(hasItem(DEFAULT_RATIO_ASSIGNEE)))
            .andExpect(jsonPath("$.[*].drrAssignee").value(hasItem(DEFAULT_DRR_ASSIGNEE)))
            .andExpect(jsonPath("$.[*].businessKey").value(hasItem(DEFAULT_BUSINESS_KEY)))
            .andExpect(jsonPath("$.[*].initiationDate").value(hasItem(DEFAULT_INITIATION_DATE)))
            .andExpect(jsonPath("$.[*].reviewOutcome").value(hasItem(DEFAULT_REVIEW_OUTCOME)))
            .andExpect(jsonPath("$.[*].ubsDivision").value(hasItem(DEFAULT_UBS_DIVISION)))
            .andExpect(jsonPath("$.[*].commentReject").value(hasItem(DEFAULT_COMMENT_REJECT)))
            .andExpect(jsonPath("$.[*].rejectOrEscalate").value(hasItem(DEFAULT_REJECT_OR_ESCALATE)))
            .andExpect(jsonPath("$.[*].attachmentEscalation").value(hasItem(DEFAULT_ATTACHMENT_ESCALATION)))
            .andExpect(jsonPath("$.[*].attachmentEscalationNoCID").value(hasItem(DEFAULT_ATTACHMENT_ESCALATION_NO_CID)))
            .andExpect(jsonPath("$.[*].callbackId").value(hasItem(DEFAULT_CALLBACK_ID)))
            .andExpect(jsonPath("$.[*].callbackType").value(hasItem(DEFAULT_CALLBACK_TYPE)))
            .andExpect(jsonPath("$.[*].caseDefinitionId").value(hasItem(DEFAULT_CASE_DEFINITION_ID)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].parentId").value(hasItem(DEFAULT_PARENT_ID)))
            .andExpect(jsonPath("$.[*].startTime").value(hasItem(DEFAULT_START_TIME.toString())))
            .andExpect(jsonPath("$.[*].startUserId").value(hasItem(DEFAULT_START_USER_ID)))
            .andExpect(jsonPath("$.[*].state").value(hasItem(DEFAULT_STATE)))
            .andExpect(jsonPath("$.[*].tenantId").value(hasItem(DEFAULT_TENANT_ID)));
    }
    
    @Test
    @Transactional
    public void getSTIRCase() throws Exception {
        // Initialize the database
        sTIRCaseRepository.saveAndFlush(sTIRCase);

        // Get the sTIRCase
        restSTIRCaseMockMvc.perform(get("/api/stir-cases/{id}", sTIRCase.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(sTIRCase.getId().intValue()))
            .andExpect(jsonPath("$.entityName").value(DEFAULT_ENTITY_NAME))
            .andExpect(jsonPath("$.entity").value(DEFAULT_ENTITY))
            .andExpect(jsonPath("$.lsdbID").value(DEFAULT_LSDB_ID))
            .andExpect(jsonPath("$.relationship").value(DEFAULT_RELATIONSHIP))
            .andExpect(jsonPath("$.vendorRAGstatus").value(DEFAULT_VENDOR_RA_GSTATUS))
            .andExpect(jsonPath("$.explanationOfEstimate").value(DEFAULT_EXPLANATION_OF_ESTIMATE))
            .andExpect(jsonPath("$.repRiskConcerns").value(DEFAULT_REP_RISK_CONCERNS))
            .andExpect(jsonPath("$.relationshipDescription").value(DEFAULT_RELATIONSHIP_DESCRIPTION))
            .andExpect(jsonPath("$.i1na").value(DEFAULT_I_1_NA))
            .andExpect(jsonPath("$.i2na").value(DEFAULT_I_2_NA))
            .andExpect(jsonPath("$.i3na").value(DEFAULT_I_3_NA))
            .andExpect(jsonPath("$.i4na").value(DEFAULT_I_4_NA))
            .andExpect(jsonPath("$.i5na").value(DEFAULT_I_5_NA))
            .andExpect(jsonPath("$.i6na").value(DEFAULT_I_6_NA))
            .andExpect(jsonPath("$.i7na").value(DEFAULT_I_7_NA))
            .andExpect(jsonPath("$.i8na").value(DEFAULT_I_8_NA))
            .andExpect(jsonPath("$.i9na").value(DEFAULT_I_9_NA))
            .andExpect(jsonPath("$.i10na").value(DEFAULT_I_10_NA))
            .andExpect(jsonPath("$.i11na").value(DEFAULT_I_11_NA))
            .andExpect(jsonPath("$.i12na").value(DEFAULT_I_12_NA))
            .andExpect(jsonPath("$.indicatorDiscuss1").value(DEFAULT_INDICATOR_DISCUSS_1))
            .andExpect(jsonPath("$.indicatorDiscuss2").value(DEFAULT_INDICATOR_DISCUSS_2))
            .andExpect(jsonPath("$.indicatorDiscuss3").value(DEFAULT_INDICATOR_DISCUSS_3))
            .andExpect(jsonPath("$.indicatorDiscuss4").value(DEFAULT_INDICATOR_DISCUSS_4))
            .andExpect(jsonPath("$.indicatorDiscuss5").value(DEFAULT_INDICATOR_DISCUSS_5))
            .andExpect(jsonPath("$.indicatorDiscuss6").value(DEFAULT_INDICATOR_DISCUSS_6))
            .andExpect(jsonPath("$.indicatorDiscuss7").value(DEFAULT_INDICATOR_DISCUSS_7))
            .andExpect(jsonPath("$.indicatorDiscuss8").value(DEFAULT_INDICATOR_DISCUSS_8))
            .andExpect(jsonPath("$.indicatorDiscuss9").value(DEFAULT_INDICATOR_DISCUSS_9))
            .andExpect(jsonPath("$.indicatorDiscuss10").value(DEFAULT_INDICATOR_DISCUSS_10))
            .andExpect(jsonPath("$.indicatorDiscuss11").value(DEFAULT_INDICATOR_DISCUSS_11))
            .andExpect(jsonPath("$.indicatorDiscuss12").value(DEFAULT_INDICATOR_DISCUSS_12))
            .andExpect(jsonPath("$.decision").value(DEFAULT_DECISION))
            .andExpect(jsonPath("$.potentialMitigatingActions").value(DEFAULT_POTENTIAL_MITIGATING_ACTIONS))
            .andExpect(jsonPath("$.commentChallenge").value(DEFAULT_COMMENT_CHALLENGE))
            .andExpect(jsonPath("$.commentValidate").value(DEFAULT_COMMENT_VALIDATE))
            .andExpect(jsonPath("$.entityInfoRC").value(DEFAULT_ENTITY_INFO_RC))
            .andExpect(jsonPath("$.stepInEstimationRC").value(DEFAULT_STEP_IN_ESTIMATION_RC))
            .andExpect(jsonPath("$.impactAnalysisRC").value(DEFAULT_IMPACT_ANALYSIS_RC))
            .andExpect(jsonPath("$.indicatorAnalysisRC").value(DEFAULT_INDICATOR_ANALYSIS_RC))
            .andExpect(jsonPath("$.entityBelowBSponsor").value(DEFAULT_ENTITY_BELOW_B_SPONSOR))
            .andExpect(jsonPath("$.isSPE").value(DEFAULT_IS_SPE))
            .andExpect(jsonPath("$.noneOfTheAboveA").value(DEFAULT_NONE_OF_THE_ABOVE_A))
            .andExpect(jsonPath("$.entityBelowBInvestor").value(DEFAULT_ENTITY_BELOW_B_INVESTOR))
            .andExpect(jsonPath("$.equityHoldingsPerPolicy").value(DEFAULT_EQUITY_HOLDINGS_PER_POLICY))
            .andExpect(jsonPath("$.debtHoldingsInScope").value(DEFAULT_DEBT_HOLDINGS_IN_SCOPE))
            .andExpect(jsonPath("$.noneOfTheAboveB").value(DEFAULT_NONE_OF_THE_ABOVE_B))
            .andExpect(jsonPath("$.tier1Vendor").value(DEFAULT_TIER_1_VENDOR))
            .andExpect(jsonPath("$.noneOfTheAboveC").value(DEFAULT_NONE_OF_THE_ABOVE_C))
            .andExpect(jsonPath("$.entityType").value(DEFAULT_ENTITY_TYPE))
            .andExpect(jsonPath("$.entityTypeOther").value(DEFAULT_ENTITY_TYPE_OTHER))
            .andExpect(jsonPath("$.attachment").value(DEFAULT_ATTACHMENT))
            .andExpect(jsonPath("$.attachmentNoCID").value(DEFAULT_ATTACHMENT_NO_CID))
            .andExpect(jsonPath("$.attachmentComment").value(DEFAULT_ATTACHMENT_COMMENT))
            .andExpect(jsonPath("$.typeOfSupportAnticipated").value(DEFAULT_TYPE_OF_SUPPORT_ANTICIPATED))
            .andExpect(jsonPath("$.instrumentOfTradingOrBankingBook").value(DEFAULT_INSTRUMENT_OF_TRADING_OR_BANKING_BOOK))
            .andExpect(jsonPath("$.regTreatment").value(DEFAULT_REG_TREATMENT))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.accountingIFRSTreatment").value(DEFAULT_ACCOUNTING_IFRS_TREATMENT))
            .andExpect(jsonPath("$.accountingIFRSTreatmentEquity").value(DEFAULT_ACCOUNTING_IFRS_TREATMENT_EQUITY))
            .andExpect(jsonPath("$.accountingIFRSTreatmentDebt").value(DEFAULT_ACCOUNTING_IFRS_TREATMENT_DEBT))
            .andExpect(jsonPath("$.totalAssetSize").value(DEFAULT_TOTAL_ASSET_SIZE))
            .andExpect(jsonPath("$.uncalledCommitment").value(DEFAULT_UNCALLED_COMMITMENT))
            .andExpect(jsonPath("$.currentAUM").value(DEFAULT_CURRENT_AUM))
            .andExpect(jsonPath("$.targetAUM").value(DEFAULT_TARGET_AUM))
            .andExpect(jsonPath("$.stepInRiskAmount").value(DEFAULT_STEP_IN_RISK_AMOUNT))
            .andExpect(jsonPath("$.contractualExposureInMillionUSD").value(DEFAULT_CONTRACTUAL_EXPOSURE_IN_MILLION_USD))
            .andExpect(jsonPath("$.amconf1").value(DEFAULT_AMCONF_1))
            .andExpect(jsonPath("$.amconf2").value(DEFAULT_AMCONF_2))
            .andExpect(jsonPath("$.amconf3").value(DEFAULT_AMCONF_3))
            .andExpect(jsonPath("$.dRRdecision").value(DEFAULT_D_R_RDECISION))
            .andExpect(jsonPath("$.optionalComment").value(DEFAULT_OPTIONAL_COMMENT))
            .andExpect(jsonPath("$.optionalCommentRatios").value(DEFAULT_OPTIONAL_COMMENT_RATIOS))
            .andExpect(jsonPath("$.rejectionRationale").value(DEFAULT_REJECTION_RATIONALE))
            .andExpect(jsonPath("$.dueDate").value(DEFAULT_DUE_DATE))
            .andExpect(jsonPath("$.caseType").value(DEFAULT_CASE_TYPE))
            .andExpect(jsonPath("$.caseName").value(DEFAULT_CASE_NAME))
            .andExpect(jsonPath("$.endTime").value(DEFAULT_END_TIME.toString()))
            .andExpect(jsonPath("$.caseDueDate").value(DEFAULT_CASE_DUE_DATE))
            .andExpect(jsonPath("$.firstLoDInitiator").value(DEFAULT_FIRST_LO_D_INITIATOR))
            .andExpect(jsonPath("$.secondLoDAssignee").value(DEFAULT_SECOND_LO_D_ASSIGNEE))
            .andExpect(jsonPath("$.ratioAssignee").value(DEFAULT_RATIO_ASSIGNEE))
            .andExpect(jsonPath("$.drrAssignee").value(DEFAULT_DRR_ASSIGNEE))
            .andExpect(jsonPath("$.businessKey").value(DEFAULT_BUSINESS_KEY))
            .andExpect(jsonPath("$.initiationDate").value(DEFAULT_INITIATION_DATE))
            .andExpect(jsonPath("$.reviewOutcome").value(DEFAULT_REVIEW_OUTCOME))
            .andExpect(jsonPath("$.ubsDivision").value(DEFAULT_UBS_DIVISION))
            .andExpect(jsonPath("$.commentReject").value(DEFAULT_COMMENT_REJECT))
            .andExpect(jsonPath("$.rejectOrEscalate").value(DEFAULT_REJECT_OR_ESCALATE))
            .andExpect(jsonPath("$.attachmentEscalation").value(DEFAULT_ATTACHMENT_ESCALATION))
            .andExpect(jsonPath("$.attachmentEscalationNoCID").value(DEFAULT_ATTACHMENT_ESCALATION_NO_CID))
            .andExpect(jsonPath("$.callbackId").value(DEFAULT_CALLBACK_ID))
            .andExpect(jsonPath("$.callbackType").value(DEFAULT_CALLBACK_TYPE))
            .andExpect(jsonPath("$.caseDefinitionId").value(DEFAULT_CASE_DEFINITION_ID))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.parentId").value(DEFAULT_PARENT_ID))
            .andExpect(jsonPath("$.startTime").value(DEFAULT_START_TIME.toString()))
            .andExpect(jsonPath("$.startUserId").value(DEFAULT_START_USER_ID))
            .andExpect(jsonPath("$.state").value(DEFAULT_STATE))
            .andExpect(jsonPath("$.tenantId").value(DEFAULT_TENANT_ID));
    }

    @Test
    @Transactional
    public void getNonExistingSTIRCase() throws Exception {
        // Get the sTIRCase
        restSTIRCaseMockMvc.perform(get("/api/stir-cases/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSTIRCase() throws Exception {
        // Initialize the database
        sTIRCaseRepository.saveAndFlush(sTIRCase);

        int databaseSizeBeforeUpdate = sTIRCaseRepository.findAll().size();

        // Update the sTIRCase
        STIRCase updatedSTIRCase = sTIRCaseRepository.findById(sTIRCase.getId()).get();
        // Disconnect from session so that the updates on updatedSTIRCase are not directly saved in db
        em.detach(updatedSTIRCase);
        updatedSTIRCase
            .entityName(UPDATED_ENTITY_NAME)
            .entity(UPDATED_ENTITY)
            .lsdbID(UPDATED_LSDB_ID)
            .relationship(UPDATED_RELATIONSHIP)
            .vendorRAGstatus(UPDATED_VENDOR_RA_GSTATUS)
            .explanationOfEstimate(UPDATED_EXPLANATION_OF_ESTIMATE)
            .repRiskConcerns(UPDATED_REP_RISK_CONCERNS)
            .relationshipDescription(UPDATED_RELATIONSHIP_DESCRIPTION)
            .i1na(UPDATED_I_1_NA)
            .i2na(UPDATED_I_2_NA)
            .i3na(UPDATED_I_3_NA)
            .i4na(UPDATED_I_4_NA)
            .i5na(UPDATED_I_5_NA)
            .i6na(UPDATED_I_6_NA)
            .i7na(UPDATED_I_7_NA)
            .i8na(UPDATED_I_8_NA)
            .i9na(UPDATED_I_9_NA)
            .i10na(UPDATED_I_10_NA)
            .i11na(UPDATED_I_11_NA)
            .i12na(UPDATED_I_12_NA)
            .indicatorDiscuss1(UPDATED_INDICATOR_DISCUSS_1)
            .indicatorDiscuss2(UPDATED_INDICATOR_DISCUSS_2)
            .indicatorDiscuss3(UPDATED_INDICATOR_DISCUSS_3)
            .indicatorDiscuss4(UPDATED_INDICATOR_DISCUSS_4)
            .indicatorDiscuss5(UPDATED_INDICATOR_DISCUSS_5)
            .indicatorDiscuss6(UPDATED_INDICATOR_DISCUSS_6)
            .indicatorDiscuss7(UPDATED_INDICATOR_DISCUSS_7)
            .indicatorDiscuss8(UPDATED_INDICATOR_DISCUSS_8)
            .indicatorDiscuss9(UPDATED_INDICATOR_DISCUSS_9)
            .indicatorDiscuss10(UPDATED_INDICATOR_DISCUSS_10)
            .indicatorDiscuss11(UPDATED_INDICATOR_DISCUSS_11)
            .indicatorDiscuss12(UPDATED_INDICATOR_DISCUSS_12)
            .decision(UPDATED_DECISION)
            .potentialMitigatingActions(UPDATED_POTENTIAL_MITIGATING_ACTIONS)
            .commentChallenge(UPDATED_COMMENT_CHALLENGE)
            .commentValidate(UPDATED_COMMENT_VALIDATE)
            .entityInfoRC(UPDATED_ENTITY_INFO_RC)
            .stepInEstimationRC(UPDATED_STEP_IN_ESTIMATION_RC)
            .impactAnalysisRC(UPDATED_IMPACT_ANALYSIS_RC)
            .indicatorAnalysisRC(UPDATED_INDICATOR_ANALYSIS_RC)
            .entityBelowBSponsor(UPDATED_ENTITY_BELOW_B_SPONSOR)
            .isSPE(UPDATED_IS_SPE)
            .noneOfTheAboveA(UPDATED_NONE_OF_THE_ABOVE_A)
            .entityBelowBInvestor(UPDATED_ENTITY_BELOW_B_INVESTOR)
            .equityHoldingsPerPolicy(UPDATED_EQUITY_HOLDINGS_PER_POLICY)
            .debtHoldingsInScope(UPDATED_DEBT_HOLDINGS_IN_SCOPE)
            .noneOfTheAboveB(UPDATED_NONE_OF_THE_ABOVE_B)
            .tier1Vendor(UPDATED_TIER_1_VENDOR)
            .noneOfTheAboveC(UPDATED_NONE_OF_THE_ABOVE_C)
            .entityType(UPDATED_ENTITY_TYPE)
            .entityTypeOther(UPDATED_ENTITY_TYPE_OTHER)
            .attachment(UPDATED_ATTACHMENT)
            .attachmentNoCID(UPDATED_ATTACHMENT_NO_CID)
            .attachmentComment(UPDATED_ATTACHMENT_COMMENT)
            .typeOfSupportAnticipated(UPDATED_TYPE_OF_SUPPORT_ANTICIPATED)
            .instrumentOfTradingOrBankingBook(UPDATED_INSTRUMENT_OF_TRADING_OR_BANKING_BOOK)
            .regTreatment(UPDATED_REG_TREATMENT)
            .description(UPDATED_DESCRIPTION)
            .accountingIFRSTreatment(UPDATED_ACCOUNTING_IFRS_TREATMENT)
            .accountingIFRSTreatmentEquity(UPDATED_ACCOUNTING_IFRS_TREATMENT_EQUITY)
            .accountingIFRSTreatmentDebt(UPDATED_ACCOUNTING_IFRS_TREATMENT_DEBT)
            .totalAssetSize(UPDATED_TOTAL_ASSET_SIZE)
            .uncalledCommitment(UPDATED_UNCALLED_COMMITMENT)
            .currentAUM(UPDATED_CURRENT_AUM)
            .targetAUM(UPDATED_TARGET_AUM)
            .stepInRiskAmount(UPDATED_STEP_IN_RISK_AMOUNT)
            .contractualExposureInMillionUSD(UPDATED_CONTRACTUAL_EXPOSURE_IN_MILLION_USD)
            .amconf1(UPDATED_AMCONF_1)
            .amconf2(UPDATED_AMCONF_2)
            .amconf3(UPDATED_AMCONF_3)
            .dRRdecision(UPDATED_D_R_RDECISION)
            .optionalComment(UPDATED_OPTIONAL_COMMENT)
            .optionalCommentRatios(UPDATED_OPTIONAL_COMMENT_RATIOS)
            .rejectionRationale(UPDATED_REJECTION_RATIONALE)
            .dueDate(UPDATED_DUE_DATE)
            .caseType(UPDATED_CASE_TYPE)
            .caseName(UPDATED_CASE_NAME)
            .endTime(UPDATED_END_TIME)
            .caseDueDate(UPDATED_CASE_DUE_DATE)
            .firstLoDInitiator(UPDATED_FIRST_LO_D_INITIATOR)
            .secondLoDAssignee(UPDATED_SECOND_LO_D_ASSIGNEE)
            .ratioAssignee(UPDATED_RATIO_ASSIGNEE)
            .drrAssignee(UPDATED_DRR_ASSIGNEE)
            .businessKey(UPDATED_BUSINESS_KEY)
            .initiationDate(UPDATED_INITIATION_DATE)
            .reviewOutcome(UPDATED_REVIEW_OUTCOME)
            .ubsDivision(UPDATED_UBS_DIVISION)
            .commentReject(UPDATED_COMMENT_REJECT)
            .rejectOrEscalate(UPDATED_REJECT_OR_ESCALATE)
            .attachmentEscalation(UPDATED_ATTACHMENT_ESCALATION)
            .attachmentEscalationNoCID(UPDATED_ATTACHMENT_ESCALATION_NO_CID)
            .callbackId(UPDATED_CALLBACK_ID)
            .callbackType(UPDATED_CALLBACK_TYPE)
            .caseDefinitionId(UPDATED_CASE_DEFINITION_ID)
            .name(UPDATED_NAME)
            .parentId(UPDATED_PARENT_ID)
            .startTime(UPDATED_START_TIME)
            .startUserId(UPDATED_START_USER_ID)
            .state(UPDATED_STATE)
            .tenantId(UPDATED_TENANT_ID);

        restSTIRCaseMockMvc.perform(put("/api/stir-cases")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedSTIRCase)))
            .andExpect(status().isOk());

        // Validate the STIRCase in the database
        List<STIRCase> sTIRCaseList = sTIRCaseRepository.findAll();
        assertThat(sTIRCaseList).hasSize(databaseSizeBeforeUpdate);
        STIRCase testSTIRCase = sTIRCaseList.get(sTIRCaseList.size() - 1);
        assertThat(testSTIRCase.getEntityName()).isEqualTo(UPDATED_ENTITY_NAME);
        assertThat(testSTIRCase.getEntity()).isEqualTo(UPDATED_ENTITY);
        assertThat(testSTIRCase.getLsdbID()).isEqualTo(UPDATED_LSDB_ID);
        assertThat(testSTIRCase.getRelationship()).isEqualTo(UPDATED_RELATIONSHIP);
        assertThat(testSTIRCase.getVendorRAGstatus()).isEqualTo(UPDATED_VENDOR_RA_GSTATUS);
        assertThat(testSTIRCase.getExplanationOfEstimate()).isEqualTo(UPDATED_EXPLANATION_OF_ESTIMATE);
        assertThat(testSTIRCase.getRepRiskConcerns()).isEqualTo(UPDATED_REP_RISK_CONCERNS);
        assertThat(testSTIRCase.getRelationshipDescription()).isEqualTo(UPDATED_RELATIONSHIP_DESCRIPTION);
        assertThat(testSTIRCase.geti1na()).isEqualTo(UPDATED_I_1_NA);
        assertThat(testSTIRCase.geti2na()).isEqualTo(UPDATED_I_2_NA);
        assertThat(testSTIRCase.geti3na()).isEqualTo(UPDATED_I_3_NA);
        assertThat(testSTIRCase.geti4na()).isEqualTo(UPDATED_I_4_NA);
        assertThat(testSTIRCase.geti5na()).isEqualTo(UPDATED_I_5_NA);
        assertThat(testSTIRCase.geti6na()).isEqualTo(UPDATED_I_6_NA);
        assertThat(testSTIRCase.geti7na()).isEqualTo(UPDATED_I_7_NA);
        assertThat(testSTIRCase.geti8na()).isEqualTo(UPDATED_I_8_NA);
        assertThat(testSTIRCase.geti9na()).isEqualTo(UPDATED_I_9_NA);
        assertThat(testSTIRCase.geti10na()).isEqualTo(UPDATED_I_10_NA);
        assertThat(testSTIRCase.geti11na()).isEqualTo(UPDATED_I_11_NA);
        assertThat(testSTIRCase.geti12na()).isEqualTo(UPDATED_I_12_NA);
        assertThat(testSTIRCase.getIndicatorDiscuss1()).isEqualTo(UPDATED_INDICATOR_DISCUSS_1);
        assertThat(testSTIRCase.getIndicatorDiscuss2()).isEqualTo(UPDATED_INDICATOR_DISCUSS_2);
        assertThat(testSTIRCase.getIndicatorDiscuss3()).isEqualTo(UPDATED_INDICATOR_DISCUSS_3);
        assertThat(testSTIRCase.getIndicatorDiscuss4()).isEqualTo(UPDATED_INDICATOR_DISCUSS_4);
        assertThat(testSTIRCase.getIndicatorDiscuss5()).isEqualTo(UPDATED_INDICATOR_DISCUSS_5);
        assertThat(testSTIRCase.getIndicatorDiscuss6()).isEqualTo(UPDATED_INDICATOR_DISCUSS_6);
        assertThat(testSTIRCase.getIndicatorDiscuss7()).isEqualTo(UPDATED_INDICATOR_DISCUSS_7);
        assertThat(testSTIRCase.getIndicatorDiscuss8()).isEqualTo(UPDATED_INDICATOR_DISCUSS_8);
        assertThat(testSTIRCase.getIndicatorDiscuss9()).isEqualTo(UPDATED_INDICATOR_DISCUSS_9);
        assertThat(testSTIRCase.getIndicatorDiscuss10()).isEqualTo(UPDATED_INDICATOR_DISCUSS_10);
        assertThat(testSTIRCase.getIndicatorDiscuss11()).isEqualTo(UPDATED_INDICATOR_DISCUSS_11);
        assertThat(testSTIRCase.getIndicatorDiscuss12()).isEqualTo(UPDATED_INDICATOR_DISCUSS_12);
        assertThat(testSTIRCase.getDecision()).isEqualTo(UPDATED_DECISION);
        assertThat(testSTIRCase.getPotentialMitigatingActions()).isEqualTo(UPDATED_POTENTIAL_MITIGATING_ACTIONS);
        assertThat(testSTIRCase.getCommentChallenge()).isEqualTo(UPDATED_COMMENT_CHALLENGE);
        assertThat(testSTIRCase.getCommentValidate()).isEqualTo(UPDATED_COMMENT_VALIDATE);
        assertThat(testSTIRCase.getEntityInfoRC()).isEqualTo(UPDATED_ENTITY_INFO_RC);
        assertThat(testSTIRCase.getStepInEstimationRC()).isEqualTo(UPDATED_STEP_IN_ESTIMATION_RC);
        assertThat(testSTIRCase.getImpactAnalysisRC()).isEqualTo(UPDATED_IMPACT_ANALYSIS_RC);
        assertThat(testSTIRCase.getIndicatorAnalysisRC()).isEqualTo(UPDATED_INDICATOR_ANALYSIS_RC);
        assertThat(testSTIRCase.getEntityBelowBSponsor()).isEqualTo(UPDATED_ENTITY_BELOW_B_SPONSOR);
        assertThat(testSTIRCase.getIsSPE()).isEqualTo(UPDATED_IS_SPE);
        assertThat(testSTIRCase.getNoneOfTheAboveA()).isEqualTo(UPDATED_NONE_OF_THE_ABOVE_A);
        assertThat(testSTIRCase.getEntityBelowBInvestor()).isEqualTo(UPDATED_ENTITY_BELOW_B_INVESTOR);
        assertThat(testSTIRCase.getEquityHoldingsPerPolicy()).isEqualTo(UPDATED_EQUITY_HOLDINGS_PER_POLICY);
        assertThat(testSTIRCase.getDebtHoldingsInScope()).isEqualTo(UPDATED_DEBT_HOLDINGS_IN_SCOPE);
        assertThat(testSTIRCase.getNoneOfTheAboveB()).isEqualTo(UPDATED_NONE_OF_THE_ABOVE_B);
        assertThat(testSTIRCase.getTier1Vendor()).isEqualTo(UPDATED_TIER_1_VENDOR);
        assertThat(testSTIRCase.getNoneOfTheAboveC()).isEqualTo(UPDATED_NONE_OF_THE_ABOVE_C);
        assertThat(testSTIRCase.getEntityType()).isEqualTo(UPDATED_ENTITY_TYPE);
        assertThat(testSTIRCase.getEntityTypeOther()).isEqualTo(UPDATED_ENTITY_TYPE_OTHER);
        assertThat(testSTIRCase.getAttachment()).isEqualTo(UPDATED_ATTACHMENT);
        assertThat(testSTIRCase.getAttachmentNoCID()).isEqualTo(UPDATED_ATTACHMENT_NO_CID);
        assertThat(testSTIRCase.getAttachmentComment()).isEqualTo(UPDATED_ATTACHMENT_COMMENT);
        assertThat(testSTIRCase.getTypeOfSupportAnticipated()).isEqualTo(UPDATED_TYPE_OF_SUPPORT_ANTICIPATED);
        assertThat(testSTIRCase.getInstrumentOfTradingOrBankingBook()).isEqualTo(UPDATED_INSTRUMENT_OF_TRADING_OR_BANKING_BOOK);
        assertThat(testSTIRCase.getRegTreatment()).isEqualTo(UPDATED_REG_TREATMENT);
        assertThat(testSTIRCase.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testSTIRCase.getAccountingIFRSTreatment()).isEqualTo(UPDATED_ACCOUNTING_IFRS_TREATMENT);
        assertThat(testSTIRCase.getAccountingIFRSTreatmentEquity()).isEqualTo(UPDATED_ACCOUNTING_IFRS_TREATMENT_EQUITY);
        assertThat(testSTIRCase.getAccountingIFRSTreatmentDebt()).isEqualTo(UPDATED_ACCOUNTING_IFRS_TREATMENT_DEBT);
        assertThat(testSTIRCase.getTotalAssetSize()).isEqualTo(UPDATED_TOTAL_ASSET_SIZE);
        assertThat(testSTIRCase.getUncalledCommitment()).isEqualTo(UPDATED_UNCALLED_COMMITMENT);
        assertThat(testSTIRCase.getCurrentAUM()).isEqualTo(UPDATED_CURRENT_AUM);
        assertThat(testSTIRCase.getTargetAUM()).isEqualTo(UPDATED_TARGET_AUM);
        assertThat(testSTIRCase.getStepInRiskAmount()).isEqualTo(UPDATED_STEP_IN_RISK_AMOUNT);
        assertThat(testSTIRCase.getContractualExposureInMillionUSD()).isEqualTo(UPDATED_CONTRACTUAL_EXPOSURE_IN_MILLION_USD);
        assertThat(testSTIRCase.getAmconf1()).isEqualTo(UPDATED_AMCONF_1);
        assertThat(testSTIRCase.getAmconf2()).isEqualTo(UPDATED_AMCONF_2);
        assertThat(testSTIRCase.getAmconf3()).isEqualTo(UPDATED_AMCONF_3);
        assertThat(testSTIRCase.getdRRdecision()).isEqualTo(UPDATED_D_R_RDECISION);
        assertThat(testSTIRCase.getOptionalComment()).isEqualTo(UPDATED_OPTIONAL_COMMENT);
        assertThat(testSTIRCase.getOptionalCommentRatios()).isEqualTo(UPDATED_OPTIONAL_COMMENT_RATIOS);
        assertThat(testSTIRCase.getRejectionRationale()).isEqualTo(UPDATED_REJECTION_RATIONALE);
        assertThat(testSTIRCase.getDueDate()).isEqualTo(UPDATED_DUE_DATE);
        assertThat(testSTIRCase.getCaseType()).isEqualTo(UPDATED_CASE_TYPE);
        assertThat(testSTIRCase.getCaseName()).isEqualTo(UPDATED_CASE_NAME);
        assertThat(testSTIRCase.getEndTime()).isEqualTo(UPDATED_END_TIME);
        assertThat(testSTIRCase.getCaseDueDate()).isEqualTo(UPDATED_CASE_DUE_DATE);
        assertThat(testSTIRCase.getFirstLoDInitiator()).isEqualTo(UPDATED_FIRST_LO_D_INITIATOR);
        assertThat(testSTIRCase.getSecondLoDAssignee()).isEqualTo(UPDATED_SECOND_LO_D_ASSIGNEE);
        assertThat(testSTIRCase.getRatioAssignee()).isEqualTo(UPDATED_RATIO_ASSIGNEE);
        assertThat(testSTIRCase.getDrrAssignee()).isEqualTo(UPDATED_DRR_ASSIGNEE);
        assertThat(testSTIRCase.getBusinessKey()).isEqualTo(UPDATED_BUSINESS_KEY);
        assertThat(testSTIRCase.getInitiationDate()).isEqualTo(UPDATED_INITIATION_DATE);
        assertThat(testSTIRCase.getReviewOutcome()).isEqualTo(UPDATED_REVIEW_OUTCOME);
        assertThat(testSTIRCase.getUbsDivision()).isEqualTo(UPDATED_UBS_DIVISION);
        assertThat(testSTIRCase.getCommentReject()).isEqualTo(UPDATED_COMMENT_REJECT);
        assertThat(testSTIRCase.getRejectOrEscalate()).isEqualTo(UPDATED_REJECT_OR_ESCALATE);
        assertThat(testSTIRCase.getAttachmentEscalation()).isEqualTo(UPDATED_ATTACHMENT_ESCALATION);
        assertThat(testSTIRCase.getAttachmentEscalationNoCID()).isEqualTo(UPDATED_ATTACHMENT_ESCALATION_NO_CID);
        assertThat(testSTIRCase.getCallbackId()).isEqualTo(UPDATED_CALLBACK_ID);
        assertThat(testSTIRCase.getCallbackType()).isEqualTo(UPDATED_CALLBACK_TYPE);
        assertThat(testSTIRCase.getCaseDefinitionId()).isEqualTo(UPDATED_CASE_DEFINITION_ID);
        assertThat(testSTIRCase.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testSTIRCase.getParentId()).isEqualTo(UPDATED_PARENT_ID);
        assertThat(testSTIRCase.getStartTime()).isEqualTo(UPDATED_START_TIME);
        assertThat(testSTIRCase.getStartUserId()).isEqualTo(UPDATED_START_USER_ID);
        assertThat(testSTIRCase.getState()).isEqualTo(UPDATED_STATE);
        assertThat(testSTIRCase.getTenantId()).isEqualTo(UPDATED_TENANT_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingSTIRCase() throws Exception {
        int databaseSizeBeforeUpdate = sTIRCaseRepository.findAll().size();

        // Create the STIRCase

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSTIRCaseMockMvc.perform(put("/api/stir-cases")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sTIRCase)))
            .andExpect(status().isBadRequest());

        // Validate the STIRCase in the database
        List<STIRCase> sTIRCaseList = sTIRCaseRepository.findAll();
        assertThat(sTIRCaseList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSTIRCase() throws Exception {
        // Initialize the database
        sTIRCaseRepository.saveAndFlush(sTIRCase);

        int databaseSizeBeforeDelete = sTIRCaseRepository.findAll().size();

        // Delete the sTIRCase
        restSTIRCaseMockMvc.perform(delete("/api/stir-cases/{id}", sTIRCase.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<STIRCase> sTIRCaseList = sTIRCaseRepository.findAll();
        assertThat(sTIRCaseList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(STIRCase.class);
        STIRCase sTIRCase1 = new STIRCase();
        sTIRCase1.setId(1L);
        STIRCase sTIRCase2 = new STIRCase();
        sTIRCase2.setId(sTIRCase1.getId());
        assertThat(sTIRCase1).isEqualTo(sTIRCase2);
        sTIRCase2.setId(2L);
        assertThat(sTIRCase1).isNotEqualTo(sTIRCase2);
        sTIRCase1.setId(null);
        assertThat(sTIRCase1).isNotEqualTo(sTIRCase2);
    }
}
