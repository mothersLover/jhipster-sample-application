package com.mycompany.myapp.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A STIRCase.
 */
@Entity
@Table(name = "stir_case")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class STIRCase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "entity_name")
    private String entityName;

    @Column(name = "entity")
    private String entity;

    @Column(name = "lsdb_id")
    private String lsdbID;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "vendor_ra_gstatus")
    private String vendorRAGstatus;

    @Column(name = "explanation_of_estimate")
    private String explanationOfEstimate;

    @Column(name = "rep_risk_concerns")
    private String repRiskConcerns;

    @Column(name = "relationship_description")
    private String relationshipDescription;

    @Column(name = "i_1_na")
    private String i1na;

    @Column(name = "i_2_na")
    private String i2na;

    @Column(name = "i_3_na")
    private String i3na;

    @Column(name = "i_4_na")
    private String i4na;

    @Column(name = "i_5_na")
    private String i5na;

    @Column(name = "i_6_na")
    private String i6na;

    @Column(name = "i_7_na")
    private String i7na;

    @Column(name = "i_8_na")
    private String i8na;

    @Column(name = "i_9_na")
    private String i9na;

    @Column(name = "i_10_na")
    private String i10na;

    @Column(name = "i_11_na")
    private String i11na;

    @Column(name = "i_12_na")
    private String i12na;

    @Column(name = "indicator_discuss_1")
    private String indicatorDiscuss1;

    @Column(name = "indicator_discuss_2")
    private String indicatorDiscuss2;

    @Column(name = "indicator_discuss_3")
    private String indicatorDiscuss3;

    @Column(name = "indicator_discuss_4")
    private String indicatorDiscuss4;

    @Column(name = "indicator_discuss_5")
    private String indicatorDiscuss5;

    @Column(name = "indicator_discuss_6")
    private String indicatorDiscuss6;

    @Column(name = "indicator_discuss_7")
    private String indicatorDiscuss7;

    @Column(name = "indicator_discuss_8")
    private String indicatorDiscuss8;

    @Column(name = "indicator_discuss_9")
    private String indicatorDiscuss9;

    @Column(name = "indicator_discuss_10")
    private String indicatorDiscuss10;

    @Column(name = "indicator_discuss_11")
    private String indicatorDiscuss11;

    @Column(name = "indicator_discuss_12")
    private String indicatorDiscuss12;

    @Column(name = "decision")
    private String decision;

    @Column(name = "potential_mitigating_actions")
    private String potentialMitigatingActions;

    @Column(name = "comment_challenge")
    private String commentChallenge;

    @Column(name = "comment_validate")
    private String commentValidate;

    @Column(name = "entity_info_rc")
    private String entityInfoRC;

    @Column(name = "step_in_estimation_rc")
    private String stepInEstimationRC;

    @Column(name = "impact_analysis_rc")
    private String impactAnalysisRC;

    @Column(name = "indicator_analysis_rc")
    private String indicatorAnalysisRC;

    @Column(name = "entity_below_b_sponsor")
    private String entityBelowBSponsor;

    @Column(name = "is_spe")
    private String isSPE;

    @Column(name = "none_of_the_above_a")
    private String noneOfTheAboveA;

    @Column(name = "entity_below_b_investor")
    private String entityBelowBInvestor;

    @Column(name = "equity_holdings_per_policy")
    private String equityHoldingsPerPolicy;

    @Column(name = "debt_holdings_in_scope")
    private String debtHoldingsInScope;

    @Column(name = "none_of_the_above_b")
    private String noneOfTheAboveB;

    @Column(name = "tier_1_vendor")
    private String tier1Vendor;

    @Column(name = "none_of_the_above_c")
    private String noneOfTheAboveC;

    @Column(name = "entity_type")
    private String entityType;

    @Column(name = "entity_type_other")
    private String entityTypeOther;

    @Column(name = "attachment")
    private String attachment;

    @Column(name = "attachment_no_cid")
    private String attachmentNoCID;

    @Column(name = "attachment_comment")
    private String attachmentComment;

    @Column(name = "type_of_support_anticipated")
    private String typeOfSupportAnticipated;

    @Column(name = "instrument_of_trading_or_banking_book")
    private String instrumentOfTradingOrBankingBook;

    @Column(name = "reg_treatment")
    private String regTreatment;

    @Column(name = "description")
    private String description;

    @Column(name = "accounting_ifrs_treatment")
    private String accountingIFRSTreatment;

    @Column(name = "accounting_ifrs_treatment_equity")
    private String accountingIFRSTreatmentEquity;

    @Column(name = "accounting_ifrs_treatment_debt")
    private String accountingIFRSTreatmentDebt;

    @Column(name = "total_asset_size")
    private String totalAssetSize;

    @Column(name = "uncalled_commitment")
    private String uncalledCommitment;

    @Column(name = "current_aum")
    private String currentAUM;

    @Column(name = "target_aum")
    private String targetAUM;

    @Column(name = "step_in_risk_amount")
    private String stepInRiskAmount;

    @Column(name = "contractual_exposure_in_million_usd")
    private String contractualExposureInMillionUSD;

    @Column(name = "amconf_1")
    private String amconf1;

    @Column(name = "amconf_2")
    private String amconf2;

    @Column(name = "amconf_3")
    private String amconf3;

    @Column(name = "d_r_rdecision")
    private String dRRdecision;

    @Column(name = "optional_comment")
    private String optionalComment;

    @Column(name = "optional_comment_ratios")
    private String optionalCommentRatios;

    @Column(name = "rejection_rationale")
    private String rejectionRationale;

    @Column(name = "due_date")
    private String dueDate;

    @Column(name = "case_type")
    private String caseType;

    @Column(name = "case_name")
    private String caseName;

    @Column(name = "end_time")
    private LocalDate endTime;

    @Column(name = "case_due_date")
    private String caseDueDate;

    @Column(name = "first_lo_d_initiator")
    private String firstLoDInitiator;

    @Column(name = "second_lo_d_assignee")
    private String secondLoDAssignee;

    @Column(name = "ratio_assignee")
    private String ratioAssignee;

    @Column(name = "drr_assignee")
    private String drrAssignee;

    @Column(name = "business_key")
    private String businessKey;

    @Column(name = "initiation_date")
    private String initiationDate;

    @Column(name = "review_outcome")
    private String reviewOutcome;

    @Column(name = "ubs_division")
    private String ubsDivision;

    @Column(name = "comment_reject")
    private String commentReject;

    @Column(name = "reject_or_escalate")
    private String rejectOrEscalate;

    @Column(name = "attachment_escalation")
    private String attachmentEscalation;

    @Column(name = "attachment_escalation_no_cid")
    private String attachmentEscalationNoCID;

    @Column(name = "callback_id")
    private String callbackId;

    @Column(name = "callback_type")
    private String callbackType;

    @Column(name = "case_definition_id")
    private String caseDefinitionId;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "start_time")
    private LocalDate startTime;

    @Column(name = "start_user_id")
    private String startUserId;

    @Column(name = "state")
    private String state;

    @Column(name = "tenant_id")
    private String tenantId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public STIRCase entityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntity() {
        return entity;
    }

    public STIRCase entity(String entity) {
        this.entity = entity;
        return this;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getLsdbID() {
        return lsdbID;
    }

    public STIRCase lsdbID(String lsdbID) {
        this.lsdbID = lsdbID;
        return this;
    }

    public void setLsdbID(String lsdbID) {
        this.lsdbID = lsdbID;
    }

    public String getRelationship() {
        return relationship;
    }

    public STIRCase relationship(String relationship) {
        this.relationship = relationship;
        return this;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getVendorRAGstatus() {
        return vendorRAGstatus;
    }

    public STIRCase vendorRAGstatus(String vendorRAGstatus) {
        this.vendorRAGstatus = vendorRAGstatus;
        return this;
    }

    public void setVendorRAGstatus(String vendorRAGstatus) {
        this.vendorRAGstatus = vendorRAGstatus;
    }

    public String getExplanationOfEstimate() {
        return explanationOfEstimate;
    }

    public STIRCase explanationOfEstimate(String explanationOfEstimate) {
        this.explanationOfEstimate = explanationOfEstimate;
        return this;
    }

    public void setExplanationOfEstimate(String explanationOfEstimate) {
        this.explanationOfEstimate = explanationOfEstimate;
    }

    public String getRepRiskConcerns() {
        return repRiskConcerns;
    }

    public STIRCase repRiskConcerns(String repRiskConcerns) {
        this.repRiskConcerns = repRiskConcerns;
        return this;
    }

    public void setRepRiskConcerns(String repRiskConcerns) {
        this.repRiskConcerns = repRiskConcerns;
    }

    public String getRelationshipDescription() {
        return relationshipDescription;
    }

    public STIRCase relationshipDescription(String relationshipDescription) {
        this.relationshipDescription = relationshipDescription;
        return this;
    }

    public void setRelationshipDescription(String relationshipDescription) {
        this.relationshipDescription = relationshipDescription;
    }

    public String geti1na() {
        return i1na;
    }

    public STIRCase i1na(String i1na) {
        this.i1na = i1na;
        return this;
    }

    public void seti1na(String i1na) {
        this.i1na = i1na;
    }

    public String geti2na() {
        return i2na;
    }

    public STIRCase i2na(String i2na) {
        this.i2na = i2na;
        return this;
    }

    public void seti2na(String i2na) {
        this.i2na = i2na;
    }

    public String geti3na() {
        return i3na;
    }

    public STIRCase i3na(String i3na) {
        this.i3na = i3na;
        return this;
    }

    public void seti3na(String i3na) {
        this.i3na = i3na;
    }

    public String geti4na() {
        return i4na;
    }

    public STIRCase i4na(String i4na) {
        this.i4na = i4na;
        return this;
    }

    public void seti4na(String i4na) {
        this.i4na = i4na;
    }

    public String geti5na() {
        return i5na;
    }

    public STIRCase i5na(String i5na) {
        this.i5na = i5na;
        return this;
    }

    public void seti5na(String i5na) {
        this.i5na = i5na;
    }

    public String geti6na() {
        return i6na;
    }

    public STIRCase i6na(String i6na) {
        this.i6na = i6na;
        return this;
    }

    public void seti6na(String i6na) {
        this.i6na = i6na;
    }

    public String geti7na() {
        return i7na;
    }

    public STIRCase i7na(String i7na) {
        this.i7na = i7na;
        return this;
    }

    public void seti7na(String i7na) {
        this.i7na = i7na;
    }

    public String geti8na() {
        return i8na;
    }

    public STIRCase i8na(String i8na) {
        this.i8na = i8na;
        return this;
    }

    public void seti8na(String i8na) {
        this.i8na = i8na;
    }

    public String geti9na() {
        return i9na;
    }

    public STIRCase i9na(String i9na) {
        this.i9na = i9na;
        return this;
    }

    public void seti9na(String i9na) {
        this.i9na = i9na;
    }

    public String geti10na() {
        return i10na;
    }

    public STIRCase i10na(String i10na) {
        this.i10na = i10na;
        return this;
    }

    public void seti10na(String i10na) {
        this.i10na = i10na;
    }

    public String geti11na() {
        return i11na;
    }

    public STIRCase i11na(String i11na) {
        this.i11na = i11na;
        return this;
    }

    public void seti11na(String i11na) {
        this.i11na = i11na;
    }

    public String geti12na() {
        return i12na;
    }

    public STIRCase i12na(String i12na) {
        this.i12na = i12na;
        return this;
    }

    public void seti12na(String i12na) {
        this.i12na = i12na;
    }

    public String getIndicatorDiscuss1() {
        return indicatorDiscuss1;
    }

    public STIRCase indicatorDiscuss1(String indicatorDiscuss1) {
        this.indicatorDiscuss1 = indicatorDiscuss1;
        return this;
    }

    public void setIndicatorDiscuss1(String indicatorDiscuss1) {
        this.indicatorDiscuss1 = indicatorDiscuss1;
    }

    public String getIndicatorDiscuss2() {
        return indicatorDiscuss2;
    }

    public STIRCase indicatorDiscuss2(String indicatorDiscuss2) {
        this.indicatorDiscuss2 = indicatorDiscuss2;
        return this;
    }

    public void setIndicatorDiscuss2(String indicatorDiscuss2) {
        this.indicatorDiscuss2 = indicatorDiscuss2;
    }

    public String getIndicatorDiscuss3() {
        return indicatorDiscuss3;
    }

    public STIRCase indicatorDiscuss3(String indicatorDiscuss3) {
        this.indicatorDiscuss3 = indicatorDiscuss3;
        return this;
    }

    public void setIndicatorDiscuss3(String indicatorDiscuss3) {
        this.indicatorDiscuss3 = indicatorDiscuss3;
    }

    public String getIndicatorDiscuss4() {
        return indicatorDiscuss4;
    }

    public STIRCase indicatorDiscuss4(String indicatorDiscuss4) {
        this.indicatorDiscuss4 = indicatorDiscuss4;
        return this;
    }

    public void setIndicatorDiscuss4(String indicatorDiscuss4) {
        this.indicatorDiscuss4 = indicatorDiscuss4;
    }

    public String getIndicatorDiscuss5() {
        return indicatorDiscuss5;
    }

    public STIRCase indicatorDiscuss5(String indicatorDiscuss5) {
        this.indicatorDiscuss5 = indicatorDiscuss5;
        return this;
    }

    public void setIndicatorDiscuss5(String indicatorDiscuss5) {
        this.indicatorDiscuss5 = indicatorDiscuss5;
    }

    public String getIndicatorDiscuss6() {
        return indicatorDiscuss6;
    }

    public STIRCase indicatorDiscuss6(String indicatorDiscuss6) {
        this.indicatorDiscuss6 = indicatorDiscuss6;
        return this;
    }

    public void setIndicatorDiscuss6(String indicatorDiscuss6) {
        this.indicatorDiscuss6 = indicatorDiscuss6;
    }

    public String getIndicatorDiscuss7() {
        return indicatorDiscuss7;
    }

    public STIRCase indicatorDiscuss7(String indicatorDiscuss7) {
        this.indicatorDiscuss7 = indicatorDiscuss7;
        return this;
    }

    public void setIndicatorDiscuss7(String indicatorDiscuss7) {
        this.indicatorDiscuss7 = indicatorDiscuss7;
    }

    public String getIndicatorDiscuss8() {
        return indicatorDiscuss8;
    }

    public STIRCase indicatorDiscuss8(String indicatorDiscuss8) {
        this.indicatorDiscuss8 = indicatorDiscuss8;
        return this;
    }

    public void setIndicatorDiscuss8(String indicatorDiscuss8) {
        this.indicatorDiscuss8 = indicatorDiscuss8;
    }

    public String getIndicatorDiscuss9() {
        return indicatorDiscuss9;
    }

    public STIRCase indicatorDiscuss9(String indicatorDiscuss9) {
        this.indicatorDiscuss9 = indicatorDiscuss9;
        return this;
    }

    public void setIndicatorDiscuss9(String indicatorDiscuss9) {
        this.indicatorDiscuss9 = indicatorDiscuss9;
    }

    public String getIndicatorDiscuss10() {
        return indicatorDiscuss10;
    }

    public STIRCase indicatorDiscuss10(String indicatorDiscuss10) {
        this.indicatorDiscuss10 = indicatorDiscuss10;
        return this;
    }

    public void setIndicatorDiscuss10(String indicatorDiscuss10) {
        this.indicatorDiscuss10 = indicatorDiscuss10;
    }

    public String getIndicatorDiscuss11() {
        return indicatorDiscuss11;
    }

    public STIRCase indicatorDiscuss11(String indicatorDiscuss11) {
        this.indicatorDiscuss11 = indicatorDiscuss11;
        return this;
    }

    public void setIndicatorDiscuss11(String indicatorDiscuss11) {
        this.indicatorDiscuss11 = indicatorDiscuss11;
    }

    public String getIndicatorDiscuss12() {
        return indicatorDiscuss12;
    }

    public STIRCase indicatorDiscuss12(String indicatorDiscuss12) {
        this.indicatorDiscuss12 = indicatorDiscuss12;
        return this;
    }

    public void setIndicatorDiscuss12(String indicatorDiscuss12) {
        this.indicatorDiscuss12 = indicatorDiscuss12;
    }

    public String getDecision() {
        return decision;
    }

    public STIRCase decision(String decision) {
        this.decision = decision;
        return this;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getPotentialMitigatingActions() {
        return potentialMitigatingActions;
    }

    public STIRCase potentialMitigatingActions(String potentialMitigatingActions) {
        this.potentialMitigatingActions = potentialMitigatingActions;
        return this;
    }

    public void setPotentialMitigatingActions(String potentialMitigatingActions) {
        this.potentialMitigatingActions = potentialMitigatingActions;
    }

    public String getCommentChallenge() {
        return commentChallenge;
    }

    public STIRCase commentChallenge(String commentChallenge) {
        this.commentChallenge = commentChallenge;
        return this;
    }

    public void setCommentChallenge(String commentChallenge) {
        this.commentChallenge = commentChallenge;
    }

    public String getCommentValidate() {
        return commentValidate;
    }

    public STIRCase commentValidate(String commentValidate) {
        this.commentValidate = commentValidate;
        return this;
    }

    public void setCommentValidate(String commentValidate) {
        this.commentValidate = commentValidate;
    }

    public String getEntityInfoRC() {
        return entityInfoRC;
    }

    public STIRCase entityInfoRC(String entityInfoRC) {
        this.entityInfoRC = entityInfoRC;
        return this;
    }

    public void setEntityInfoRC(String entityInfoRC) {
        this.entityInfoRC = entityInfoRC;
    }

    public String getStepInEstimationRC() {
        return stepInEstimationRC;
    }

    public STIRCase stepInEstimationRC(String stepInEstimationRC) {
        this.stepInEstimationRC = stepInEstimationRC;
        return this;
    }

    public void setStepInEstimationRC(String stepInEstimationRC) {
        this.stepInEstimationRC = stepInEstimationRC;
    }

    public String getImpactAnalysisRC() {
        return impactAnalysisRC;
    }

    public STIRCase impactAnalysisRC(String impactAnalysisRC) {
        this.impactAnalysisRC = impactAnalysisRC;
        return this;
    }

    public void setImpactAnalysisRC(String impactAnalysisRC) {
        this.impactAnalysisRC = impactAnalysisRC;
    }

    public String getIndicatorAnalysisRC() {
        return indicatorAnalysisRC;
    }

    public STIRCase indicatorAnalysisRC(String indicatorAnalysisRC) {
        this.indicatorAnalysisRC = indicatorAnalysisRC;
        return this;
    }

    public void setIndicatorAnalysisRC(String indicatorAnalysisRC) {
        this.indicatorAnalysisRC = indicatorAnalysisRC;
    }

    public String getEntityBelowBSponsor() {
        return entityBelowBSponsor;
    }

    public STIRCase entityBelowBSponsor(String entityBelowBSponsor) {
        this.entityBelowBSponsor = entityBelowBSponsor;
        return this;
    }

    public void setEntityBelowBSponsor(String entityBelowBSponsor) {
        this.entityBelowBSponsor = entityBelowBSponsor;
    }

    public String getIsSPE() {
        return isSPE;
    }

    public STIRCase isSPE(String isSPE) {
        this.isSPE = isSPE;
        return this;
    }

    public void setIsSPE(String isSPE) {
        this.isSPE = isSPE;
    }

    public String getNoneOfTheAboveA() {
        return noneOfTheAboveA;
    }

    public STIRCase noneOfTheAboveA(String noneOfTheAboveA) {
        this.noneOfTheAboveA = noneOfTheAboveA;
        return this;
    }

    public void setNoneOfTheAboveA(String noneOfTheAboveA) {
        this.noneOfTheAboveA = noneOfTheAboveA;
    }

    public String getEntityBelowBInvestor() {
        return entityBelowBInvestor;
    }

    public STIRCase entityBelowBInvestor(String entityBelowBInvestor) {
        this.entityBelowBInvestor = entityBelowBInvestor;
        return this;
    }

    public void setEntityBelowBInvestor(String entityBelowBInvestor) {
        this.entityBelowBInvestor = entityBelowBInvestor;
    }

    public String getEquityHoldingsPerPolicy() {
        return equityHoldingsPerPolicy;
    }

    public STIRCase equityHoldingsPerPolicy(String equityHoldingsPerPolicy) {
        this.equityHoldingsPerPolicy = equityHoldingsPerPolicy;
        return this;
    }

    public void setEquityHoldingsPerPolicy(String equityHoldingsPerPolicy) {
        this.equityHoldingsPerPolicy = equityHoldingsPerPolicy;
    }

    public String getDebtHoldingsInScope() {
        return debtHoldingsInScope;
    }

    public STIRCase debtHoldingsInScope(String debtHoldingsInScope) {
        this.debtHoldingsInScope = debtHoldingsInScope;
        return this;
    }

    public void setDebtHoldingsInScope(String debtHoldingsInScope) {
        this.debtHoldingsInScope = debtHoldingsInScope;
    }

    public String getNoneOfTheAboveB() {
        return noneOfTheAboveB;
    }

    public STIRCase noneOfTheAboveB(String noneOfTheAboveB) {
        this.noneOfTheAboveB = noneOfTheAboveB;
        return this;
    }

    public void setNoneOfTheAboveB(String noneOfTheAboveB) {
        this.noneOfTheAboveB = noneOfTheAboveB;
    }

    public String getTier1Vendor() {
        return tier1Vendor;
    }

    public STIRCase tier1Vendor(String tier1Vendor) {
        this.tier1Vendor = tier1Vendor;
        return this;
    }

    public void setTier1Vendor(String tier1Vendor) {
        this.tier1Vendor = tier1Vendor;
    }

    public String getNoneOfTheAboveC() {
        return noneOfTheAboveC;
    }

    public STIRCase noneOfTheAboveC(String noneOfTheAboveC) {
        this.noneOfTheAboveC = noneOfTheAboveC;
        return this;
    }

    public void setNoneOfTheAboveC(String noneOfTheAboveC) {
        this.noneOfTheAboveC = noneOfTheAboveC;
    }

    public String getEntityType() {
        return entityType;
    }

    public STIRCase entityType(String entityType) {
        this.entityType = entityType;
        return this;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityTypeOther() {
        return entityTypeOther;
    }

    public STIRCase entityTypeOther(String entityTypeOther) {
        this.entityTypeOther = entityTypeOther;
        return this;
    }

    public void setEntityTypeOther(String entityTypeOther) {
        this.entityTypeOther = entityTypeOther;
    }

    public String getAttachment() {
        return attachment;
    }

    public STIRCase attachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getAttachmentNoCID() {
        return attachmentNoCID;
    }

    public STIRCase attachmentNoCID(String attachmentNoCID) {
        this.attachmentNoCID = attachmentNoCID;
        return this;
    }

    public void setAttachmentNoCID(String attachmentNoCID) {
        this.attachmentNoCID = attachmentNoCID;
    }

    public String getAttachmentComment() {
        return attachmentComment;
    }

    public STIRCase attachmentComment(String attachmentComment) {
        this.attachmentComment = attachmentComment;
        return this;
    }

    public void setAttachmentComment(String attachmentComment) {
        this.attachmentComment = attachmentComment;
    }

    public String getTypeOfSupportAnticipated() {
        return typeOfSupportAnticipated;
    }

    public STIRCase typeOfSupportAnticipated(String typeOfSupportAnticipated) {
        this.typeOfSupportAnticipated = typeOfSupportAnticipated;
        return this;
    }

    public void setTypeOfSupportAnticipated(String typeOfSupportAnticipated) {
        this.typeOfSupportAnticipated = typeOfSupportAnticipated;
    }

    public String getInstrumentOfTradingOrBankingBook() {
        return instrumentOfTradingOrBankingBook;
    }

    public STIRCase instrumentOfTradingOrBankingBook(String instrumentOfTradingOrBankingBook) {
        this.instrumentOfTradingOrBankingBook = instrumentOfTradingOrBankingBook;
        return this;
    }

    public void setInstrumentOfTradingOrBankingBook(String instrumentOfTradingOrBankingBook) {
        this.instrumentOfTradingOrBankingBook = instrumentOfTradingOrBankingBook;
    }

    public String getRegTreatment() {
        return regTreatment;
    }

    public STIRCase regTreatment(String regTreatment) {
        this.regTreatment = regTreatment;
        return this;
    }

    public void setRegTreatment(String regTreatment) {
        this.regTreatment = regTreatment;
    }

    public String getDescription() {
        return description;
    }

    public STIRCase description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountingIFRSTreatment() {
        return accountingIFRSTreatment;
    }

    public STIRCase accountingIFRSTreatment(String accountingIFRSTreatment) {
        this.accountingIFRSTreatment = accountingIFRSTreatment;
        return this;
    }

    public void setAccountingIFRSTreatment(String accountingIFRSTreatment) {
        this.accountingIFRSTreatment = accountingIFRSTreatment;
    }

    public String getAccountingIFRSTreatmentEquity() {
        return accountingIFRSTreatmentEquity;
    }

    public STIRCase accountingIFRSTreatmentEquity(String accountingIFRSTreatmentEquity) {
        this.accountingIFRSTreatmentEquity = accountingIFRSTreatmentEquity;
        return this;
    }

    public void setAccountingIFRSTreatmentEquity(String accountingIFRSTreatmentEquity) {
        this.accountingIFRSTreatmentEquity = accountingIFRSTreatmentEquity;
    }

    public String getAccountingIFRSTreatmentDebt() {
        return accountingIFRSTreatmentDebt;
    }

    public STIRCase accountingIFRSTreatmentDebt(String accountingIFRSTreatmentDebt) {
        this.accountingIFRSTreatmentDebt = accountingIFRSTreatmentDebt;
        return this;
    }

    public void setAccountingIFRSTreatmentDebt(String accountingIFRSTreatmentDebt) {
        this.accountingIFRSTreatmentDebt = accountingIFRSTreatmentDebt;
    }

    public String getTotalAssetSize() {
        return totalAssetSize;
    }

    public STIRCase totalAssetSize(String totalAssetSize) {
        this.totalAssetSize = totalAssetSize;
        return this;
    }

    public void setTotalAssetSize(String totalAssetSize) {
        this.totalAssetSize = totalAssetSize;
    }

    public String getUncalledCommitment() {
        return uncalledCommitment;
    }

    public STIRCase uncalledCommitment(String uncalledCommitment) {
        this.uncalledCommitment = uncalledCommitment;
        return this;
    }

    public void setUncalledCommitment(String uncalledCommitment) {
        this.uncalledCommitment = uncalledCommitment;
    }

    public String getCurrentAUM() {
        return currentAUM;
    }

    public STIRCase currentAUM(String currentAUM) {
        this.currentAUM = currentAUM;
        return this;
    }

    public void setCurrentAUM(String currentAUM) {
        this.currentAUM = currentAUM;
    }

    public String getTargetAUM() {
        return targetAUM;
    }

    public STIRCase targetAUM(String targetAUM) {
        this.targetAUM = targetAUM;
        return this;
    }

    public void setTargetAUM(String targetAUM) {
        this.targetAUM = targetAUM;
    }

    public String getStepInRiskAmount() {
        return stepInRiskAmount;
    }

    public STIRCase stepInRiskAmount(String stepInRiskAmount) {
        this.stepInRiskAmount = stepInRiskAmount;
        return this;
    }

    public void setStepInRiskAmount(String stepInRiskAmount) {
        this.stepInRiskAmount = stepInRiskAmount;
    }

    public String getContractualExposureInMillionUSD() {
        return contractualExposureInMillionUSD;
    }

    public STIRCase contractualExposureInMillionUSD(String contractualExposureInMillionUSD) {
        this.contractualExposureInMillionUSD = contractualExposureInMillionUSD;
        return this;
    }

    public void setContractualExposureInMillionUSD(String contractualExposureInMillionUSD) {
        this.contractualExposureInMillionUSD = contractualExposureInMillionUSD;
    }

    public String getAmconf1() {
        return amconf1;
    }

    public STIRCase amconf1(String amconf1) {
        this.amconf1 = amconf1;
        return this;
    }

    public void setAmconf1(String amconf1) {
        this.amconf1 = amconf1;
    }

    public String getAmconf2() {
        return amconf2;
    }

    public STIRCase amconf2(String amconf2) {
        this.amconf2 = amconf2;
        return this;
    }

    public void setAmconf2(String amconf2) {
        this.amconf2 = amconf2;
    }

    public String getAmconf3() {
        return amconf3;
    }

    public STIRCase amconf3(String amconf3) {
        this.amconf3 = amconf3;
        return this;
    }

    public void setAmconf3(String amconf3) {
        this.amconf3 = amconf3;
    }

    public String getdRRdecision() {
        return dRRdecision;
    }

    public STIRCase dRRdecision(String dRRdecision) {
        this.dRRdecision = dRRdecision;
        return this;
    }

    public void setdRRdecision(String dRRdecision) {
        this.dRRdecision = dRRdecision;
    }

    public String getOptionalComment() {
        return optionalComment;
    }

    public STIRCase optionalComment(String optionalComment) {
        this.optionalComment = optionalComment;
        return this;
    }

    public void setOptionalComment(String optionalComment) {
        this.optionalComment = optionalComment;
    }

    public String getOptionalCommentRatios() {
        return optionalCommentRatios;
    }

    public STIRCase optionalCommentRatios(String optionalCommentRatios) {
        this.optionalCommentRatios = optionalCommentRatios;
        return this;
    }

    public void setOptionalCommentRatios(String optionalCommentRatios) {
        this.optionalCommentRatios = optionalCommentRatios;
    }

    public String getRejectionRationale() {
        return rejectionRationale;
    }

    public STIRCase rejectionRationale(String rejectionRationale) {
        this.rejectionRationale = rejectionRationale;
        return this;
    }

    public void setRejectionRationale(String rejectionRationale) {
        this.rejectionRationale = rejectionRationale;
    }

    public String getDueDate() {
        return dueDate;
    }

    public STIRCase dueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCaseType() {
        return caseType;
    }

    public STIRCase caseType(String caseType) {
        this.caseType = caseType;
        return this;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseName() {
        return caseName;
    }

    public STIRCase caseName(String caseName) {
        this.caseName = caseName;
        return this;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public STIRCase endTime(LocalDate endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public String getCaseDueDate() {
        return caseDueDate;
    }

    public STIRCase caseDueDate(String caseDueDate) {
        this.caseDueDate = caseDueDate;
        return this;
    }

    public void setCaseDueDate(String caseDueDate) {
        this.caseDueDate = caseDueDate;
    }

    public String getFirstLoDInitiator() {
        return firstLoDInitiator;
    }

    public STIRCase firstLoDInitiator(String firstLoDInitiator) {
        this.firstLoDInitiator = firstLoDInitiator;
        return this;
    }

    public void setFirstLoDInitiator(String firstLoDInitiator) {
        this.firstLoDInitiator = firstLoDInitiator;
    }

    public String getSecondLoDAssignee() {
        return secondLoDAssignee;
    }

    public STIRCase secondLoDAssignee(String secondLoDAssignee) {
        this.secondLoDAssignee = secondLoDAssignee;
        return this;
    }

    public void setSecondLoDAssignee(String secondLoDAssignee) {
        this.secondLoDAssignee = secondLoDAssignee;
    }

    public String getRatioAssignee() {
        return ratioAssignee;
    }

    public STIRCase ratioAssignee(String ratioAssignee) {
        this.ratioAssignee = ratioAssignee;
        return this;
    }

    public void setRatioAssignee(String ratioAssignee) {
        this.ratioAssignee = ratioAssignee;
    }

    public String getDrrAssignee() {
        return drrAssignee;
    }

    public STIRCase drrAssignee(String drrAssignee) {
        this.drrAssignee = drrAssignee;
        return this;
    }

    public void setDrrAssignee(String drrAssignee) {
        this.drrAssignee = drrAssignee;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public STIRCase businessKey(String businessKey) {
        this.businessKey = businessKey;
        return this;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getInitiationDate() {
        return initiationDate;
    }

    public STIRCase initiationDate(String initiationDate) {
        this.initiationDate = initiationDate;
        return this;
    }

    public void setInitiationDate(String initiationDate) {
        this.initiationDate = initiationDate;
    }

    public String getReviewOutcome() {
        return reviewOutcome;
    }

    public STIRCase reviewOutcome(String reviewOutcome) {
        this.reviewOutcome = reviewOutcome;
        return this;
    }

    public void setReviewOutcome(String reviewOutcome) {
        this.reviewOutcome = reviewOutcome;
    }

    public String getUbsDivision() {
        return ubsDivision;
    }

    public STIRCase ubsDivision(String ubsDivision) {
        this.ubsDivision = ubsDivision;
        return this;
    }

    public void setUbsDivision(String ubsDivision) {
        this.ubsDivision = ubsDivision;
    }

    public String getCommentReject() {
        return commentReject;
    }

    public STIRCase commentReject(String commentReject) {
        this.commentReject = commentReject;
        return this;
    }

    public void setCommentReject(String commentReject) {
        this.commentReject = commentReject;
    }

    public String getRejectOrEscalate() {
        return rejectOrEscalate;
    }

    public STIRCase rejectOrEscalate(String rejectOrEscalate) {
        this.rejectOrEscalate = rejectOrEscalate;
        return this;
    }

    public void setRejectOrEscalate(String rejectOrEscalate) {
        this.rejectOrEscalate = rejectOrEscalate;
    }

    public String getAttachmentEscalation() {
        return attachmentEscalation;
    }

    public STIRCase attachmentEscalation(String attachmentEscalation) {
        this.attachmentEscalation = attachmentEscalation;
        return this;
    }

    public void setAttachmentEscalation(String attachmentEscalation) {
        this.attachmentEscalation = attachmentEscalation;
    }

    public String getAttachmentEscalationNoCID() {
        return attachmentEscalationNoCID;
    }

    public STIRCase attachmentEscalationNoCID(String attachmentEscalationNoCID) {
        this.attachmentEscalationNoCID = attachmentEscalationNoCID;
        return this;
    }

    public void setAttachmentEscalationNoCID(String attachmentEscalationNoCID) {
        this.attachmentEscalationNoCID = attachmentEscalationNoCID;
    }

    public String getCallbackId() {
        return callbackId;
    }

    public STIRCase callbackId(String callbackId) {
        this.callbackId = callbackId;
        return this;
    }

    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    public String getCallbackType() {
        return callbackType;
    }

    public STIRCase callbackType(String callbackType) {
        this.callbackType = callbackType;
        return this;
    }

    public void setCallbackType(String callbackType) {
        this.callbackType = callbackType;
    }

    public String getCaseDefinitionId() {
        return caseDefinitionId;
    }

    public STIRCase caseDefinitionId(String caseDefinitionId) {
        this.caseDefinitionId = caseDefinitionId;
        return this;
    }

    public void setCaseDefinitionId(String caseDefinitionId) {
        this.caseDefinitionId = caseDefinitionId;
    }

    public String getName() {
        return name;
    }

    public STIRCase name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public STIRCase parentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public STIRCase startTime(LocalDate startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public String getStartUserId() {
        return startUserId;
    }

    public STIRCase startUserId(String startUserId) {
        this.startUserId = startUserId;
        return this;
    }

    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId;
    }

    public String getState() {
        return state;
    }

    public STIRCase state(String state) {
        this.state = state;
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTenantId() {
        return tenantId;
    }

    public STIRCase tenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof STIRCase)) {
            return false;
        }
        return id != null && id.equals(((STIRCase) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "STIRCase{" +
            "id=" + getId() +
            ", entityName='" + getEntityName() + "'" +
            ", entity='" + getEntity() + "'" +
            ", lsdbID='" + getLsdbID() + "'" +
            ", relationship='" + getRelationship() + "'" +
            ", vendorRAGstatus='" + getVendorRAGstatus() + "'" +
            ", explanationOfEstimate='" + getExplanationOfEstimate() + "'" +
            ", repRiskConcerns='" + getRepRiskConcerns() + "'" +
            ", relationshipDescription='" + getRelationshipDescription() + "'" +
            ", i1na='" + geti1na() + "'" +
            ", i2na='" + geti2na() + "'" +
            ", i3na='" + geti3na() + "'" +
            ", i4na='" + geti4na() + "'" +
            ", i5na='" + geti5na() + "'" +
            ", i6na='" + geti6na() + "'" +
            ", i7na='" + geti7na() + "'" +
            ", i8na='" + geti8na() + "'" +
            ", i9na='" + geti9na() + "'" +
            ", i10na='" + geti10na() + "'" +
            ", i11na='" + geti11na() + "'" +
            ", i12na='" + geti12na() + "'" +
            ", indicatorDiscuss1='" + getIndicatorDiscuss1() + "'" +
            ", indicatorDiscuss2='" + getIndicatorDiscuss2() + "'" +
            ", indicatorDiscuss3='" + getIndicatorDiscuss3() + "'" +
            ", indicatorDiscuss4='" + getIndicatorDiscuss4() + "'" +
            ", indicatorDiscuss5='" + getIndicatorDiscuss5() + "'" +
            ", indicatorDiscuss6='" + getIndicatorDiscuss6() + "'" +
            ", indicatorDiscuss7='" + getIndicatorDiscuss7() + "'" +
            ", indicatorDiscuss8='" + getIndicatorDiscuss8() + "'" +
            ", indicatorDiscuss9='" + getIndicatorDiscuss9() + "'" +
            ", indicatorDiscuss10='" + getIndicatorDiscuss10() + "'" +
            ", indicatorDiscuss11='" + getIndicatorDiscuss11() + "'" +
            ", indicatorDiscuss12='" + getIndicatorDiscuss12() + "'" +
            ", decision='" + getDecision() + "'" +
            ", potentialMitigatingActions='" + getPotentialMitigatingActions() + "'" +
            ", commentChallenge='" + getCommentChallenge() + "'" +
            ", commentValidate='" + getCommentValidate() + "'" +
            ", entityInfoRC='" + getEntityInfoRC() + "'" +
            ", stepInEstimationRC='" + getStepInEstimationRC() + "'" +
            ", impactAnalysisRC='" + getImpactAnalysisRC() + "'" +
            ", indicatorAnalysisRC='" + getIndicatorAnalysisRC() + "'" +
            ", entityBelowBSponsor='" + getEntityBelowBSponsor() + "'" +
            ", isSPE='" + getIsSPE() + "'" +
            ", noneOfTheAboveA='" + getNoneOfTheAboveA() + "'" +
            ", entityBelowBInvestor='" + getEntityBelowBInvestor() + "'" +
            ", equityHoldingsPerPolicy='" + getEquityHoldingsPerPolicy() + "'" +
            ", debtHoldingsInScope='" + getDebtHoldingsInScope() + "'" +
            ", noneOfTheAboveB='" + getNoneOfTheAboveB() + "'" +
            ", tier1Vendor='" + getTier1Vendor() + "'" +
            ", noneOfTheAboveC='" + getNoneOfTheAboveC() + "'" +
            ", entityType='" + getEntityType() + "'" +
            ", entityTypeOther='" + getEntityTypeOther() + "'" +
            ", attachment='" + getAttachment() + "'" +
            ", attachmentNoCID='" + getAttachmentNoCID() + "'" +
            ", attachmentComment='" + getAttachmentComment() + "'" +
            ", typeOfSupportAnticipated='" + getTypeOfSupportAnticipated() + "'" +
            ", instrumentOfTradingOrBankingBook='" + getInstrumentOfTradingOrBankingBook() + "'" +
            ", regTreatment='" + getRegTreatment() + "'" +
            ", description='" + getDescription() + "'" +
            ", accountingIFRSTreatment='" + getAccountingIFRSTreatment() + "'" +
            ", accountingIFRSTreatmentEquity='" + getAccountingIFRSTreatmentEquity() + "'" +
            ", accountingIFRSTreatmentDebt='" + getAccountingIFRSTreatmentDebt() + "'" +
            ", totalAssetSize='" + getTotalAssetSize() + "'" +
            ", uncalledCommitment='" + getUncalledCommitment() + "'" +
            ", currentAUM='" + getCurrentAUM() + "'" +
            ", targetAUM='" + getTargetAUM() + "'" +
            ", stepInRiskAmount='" + getStepInRiskAmount() + "'" +
            ", contractualExposureInMillionUSD='" + getContractualExposureInMillionUSD() + "'" +
            ", amconf1='" + getAmconf1() + "'" +
            ", amconf2='" + getAmconf2() + "'" +
            ", amconf3='" + getAmconf3() + "'" +
            ", dRRdecision='" + getdRRdecision() + "'" +
            ", optionalComment='" + getOptionalComment() + "'" +
            ", optionalCommentRatios='" + getOptionalCommentRatios() + "'" +
            ", rejectionRationale='" + getRejectionRationale() + "'" +
            ", dueDate='" + getDueDate() + "'" +
            ", caseType='" + getCaseType() + "'" +
            ", caseName='" + getCaseName() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", caseDueDate='" + getCaseDueDate() + "'" +
            ", firstLoDInitiator='" + getFirstLoDInitiator() + "'" +
            ", secondLoDAssignee='" + getSecondLoDAssignee() + "'" +
            ", ratioAssignee='" + getRatioAssignee() + "'" +
            ", drrAssignee='" + getDrrAssignee() + "'" +
            ", businessKey='" + getBusinessKey() + "'" +
            ", initiationDate='" + getInitiationDate() + "'" +
            ", reviewOutcome='" + getReviewOutcome() + "'" +
            ", ubsDivision='" + getUbsDivision() + "'" +
            ", commentReject='" + getCommentReject() + "'" +
            ", rejectOrEscalate='" + getRejectOrEscalate() + "'" +
            ", attachmentEscalation='" + getAttachmentEscalation() + "'" +
            ", attachmentEscalationNoCID='" + getAttachmentEscalationNoCID() + "'" +
            ", callbackId='" + getCallbackId() + "'" +
            ", callbackType='" + getCallbackType() + "'" +
            ", caseDefinitionId='" + getCaseDefinitionId() + "'" +
            ", name='" + getName() + "'" +
            ", parentId='" + getParentId() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", startUserId='" + getStartUserId() + "'" +
            ", state='" + getState() + "'" +
            ", tenantId='" + getTenantId() + "'" +
            "}";
    }
}
