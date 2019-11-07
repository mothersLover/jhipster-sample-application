import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './stir-case.reducer';
import { ISTIRCase } from 'app/shared/model/stir-case.model';
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ISTIRCaseUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface ISTIRCaseUpdateState {
  isNew: boolean;
}

export class STIRCaseUpdate extends React.Component<ISTIRCaseUpdateProps, ISTIRCaseUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
      isNew: !this.props.match.params || !this.props.match.params.id
    };
  }

  componentWillUpdate(nextProps, nextState) {
    if (nextProps.updateSuccess !== this.props.updateSuccess && nextProps.updateSuccess) {
      this.handleClose();
    }
  }

  componentDidMount() {
    if (this.state.isNew) {
      this.props.reset();
    } else {
      this.props.getEntity(this.props.match.params.id);
    }
  }

  saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const { sTIRCaseEntity } = this.props;
      const entity = {
        ...sTIRCaseEntity,
        ...values
      };

      if (this.state.isNew) {
        this.props.createEntity(entity);
      } else {
        this.props.updateEntity(entity);
      }
    }
  };

  handleClose = () => {
    this.props.history.push('/entity/stir-case');
  };

  render() {
    const { sTIRCaseEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="archiveApp.sTIRCase.home.createOrEditLabel">Create or edit a STIRCase</h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : sTIRCaseEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="stir-case-id">ID</Label>
                    <AvInput id="stir-case-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="entityNameLabel" for="stir-case-entityName">
                    Entity Name
                  </Label>
                  <AvField id="stir-case-entityName" type="text" name="entityName" />
                </AvGroup>
                <AvGroup>
                  <Label id="entityLabel" for="stir-case-entity">
                    Entity
                  </Label>
                  <AvField id="stir-case-entity" type="text" name="entity" />
                </AvGroup>
                <AvGroup>
                  <Label id="lsdbIDLabel" for="stir-case-lsdbID">
                    Lsdb ID
                  </Label>
                  <AvField id="stir-case-lsdbID" type="text" name="lsdbID" />
                </AvGroup>
                <AvGroup>
                  <Label id="relationshipLabel" for="stir-case-relationship">
                    Relationship
                  </Label>
                  <AvField id="stir-case-relationship" type="text" name="relationship" />
                </AvGroup>
                <AvGroup>
                  <Label id="vendorRAGstatusLabel" for="stir-case-vendorRAGstatus">
                    Vendor RA Gstatus
                  </Label>
                  <AvField id="stir-case-vendorRAGstatus" type="text" name="vendorRAGstatus" />
                </AvGroup>
                <AvGroup>
                  <Label id="explanationOfEstimateLabel" for="stir-case-explanationOfEstimate">
                    Explanation Of Estimate
                  </Label>
                  <AvField id="stir-case-explanationOfEstimate" type="text" name="explanationOfEstimate" />
                </AvGroup>
                <AvGroup>
                  <Label id="repRiskConcernsLabel" for="stir-case-repRiskConcerns">
                    Rep Risk Concerns
                  </Label>
                  <AvField id="stir-case-repRiskConcerns" type="text" name="repRiskConcerns" />
                </AvGroup>
                <AvGroup>
                  <Label id="relationshipDescriptionLabel" for="stir-case-relationshipDescription">
                    Relationship Description
                  </Label>
                  <AvField id="stir-case-relationshipDescription" type="text" name="relationshipDescription" />
                </AvGroup>
                <AvGroup>
                  <Label id="i1naLabel" for="stir-case-i1na">
                    I 1 Na
                  </Label>
                  <AvField id="stir-case-i1na" type="text" name="i1na" />
                </AvGroup>
                <AvGroup>
                  <Label id="i2naLabel" for="stir-case-i2na">
                    I 2 Na
                  </Label>
                  <AvField id="stir-case-i2na" type="text" name="i2na" />
                </AvGroup>
                <AvGroup>
                  <Label id="i3naLabel" for="stir-case-i3na">
                    I 3 Na
                  </Label>
                  <AvField id="stir-case-i3na" type="text" name="i3na" />
                </AvGroup>
                <AvGroup>
                  <Label id="i4naLabel" for="stir-case-i4na">
                    I 4 Na
                  </Label>
                  <AvField id="stir-case-i4na" type="text" name="i4na" />
                </AvGroup>
                <AvGroup>
                  <Label id="i5naLabel" for="stir-case-i5na">
                    I 5 Na
                  </Label>
                  <AvField id="stir-case-i5na" type="text" name="i5na" />
                </AvGroup>
                <AvGroup>
                  <Label id="i6naLabel" for="stir-case-i6na">
                    I 6 Na
                  </Label>
                  <AvField id="stir-case-i6na" type="text" name="i6na" />
                </AvGroup>
                <AvGroup>
                  <Label id="i7naLabel" for="stir-case-i7na">
                    I 7 Na
                  </Label>
                  <AvField id="stir-case-i7na" type="text" name="i7na" />
                </AvGroup>
                <AvGroup>
                  <Label id="i8naLabel" for="stir-case-i8na">
                    I 8 Na
                  </Label>
                  <AvField id="stir-case-i8na" type="text" name="i8na" />
                </AvGroup>
                <AvGroup>
                  <Label id="i9naLabel" for="stir-case-i9na">
                    I 9 Na
                  </Label>
                  <AvField id="stir-case-i9na" type="text" name="i9na" />
                </AvGroup>
                <AvGroup>
                  <Label id="i10naLabel" for="stir-case-i10na">
                    I 10 Na
                  </Label>
                  <AvField id="stir-case-i10na" type="text" name="i10na" />
                </AvGroup>
                <AvGroup>
                  <Label id="i11naLabel" for="stir-case-i11na">
                    I 11 Na
                  </Label>
                  <AvField id="stir-case-i11na" type="text" name="i11na" />
                </AvGroup>
                <AvGroup>
                  <Label id="i12naLabel" for="stir-case-i12na">
                    I 12 Na
                  </Label>
                  <AvField id="stir-case-i12na" type="text" name="i12na" />
                </AvGroup>
                <AvGroup>
                  <Label id="indicatorDiscuss1Label" for="stir-case-indicatorDiscuss1">
                    Indicator Discuss 1
                  </Label>
                  <AvField id="stir-case-indicatorDiscuss1" type="text" name="indicatorDiscuss1" />
                </AvGroup>
                <AvGroup>
                  <Label id="indicatorDiscuss2Label" for="stir-case-indicatorDiscuss2">
                    Indicator Discuss 2
                  </Label>
                  <AvField id="stir-case-indicatorDiscuss2" type="text" name="indicatorDiscuss2" />
                </AvGroup>
                <AvGroup>
                  <Label id="indicatorDiscuss3Label" for="stir-case-indicatorDiscuss3">
                    Indicator Discuss 3
                  </Label>
                  <AvField id="stir-case-indicatorDiscuss3" type="text" name="indicatorDiscuss3" />
                </AvGroup>
                <AvGroup>
                  <Label id="indicatorDiscuss4Label" for="stir-case-indicatorDiscuss4">
                    Indicator Discuss 4
                  </Label>
                  <AvField id="stir-case-indicatorDiscuss4" type="text" name="indicatorDiscuss4" />
                </AvGroup>
                <AvGroup>
                  <Label id="indicatorDiscuss5Label" for="stir-case-indicatorDiscuss5">
                    Indicator Discuss 5
                  </Label>
                  <AvField id="stir-case-indicatorDiscuss5" type="text" name="indicatorDiscuss5" />
                </AvGroup>
                <AvGroup>
                  <Label id="indicatorDiscuss6Label" for="stir-case-indicatorDiscuss6">
                    Indicator Discuss 6
                  </Label>
                  <AvField id="stir-case-indicatorDiscuss6" type="text" name="indicatorDiscuss6" />
                </AvGroup>
                <AvGroup>
                  <Label id="indicatorDiscuss7Label" for="stir-case-indicatorDiscuss7">
                    Indicator Discuss 7
                  </Label>
                  <AvField id="stir-case-indicatorDiscuss7" type="text" name="indicatorDiscuss7" />
                </AvGroup>
                <AvGroup>
                  <Label id="indicatorDiscuss8Label" for="stir-case-indicatorDiscuss8">
                    Indicator Discuss 8
                  </Label>
                  <AvField id="stir-case-indicatorDiscuss8" type="text" name="indicatorDiscuss8" />
                </AvGroup>
                <AvGroup>
                  <Label id="indicatorDiscuss9Label" for="stir-case-indicatorDiscuss9">
                    Indicator Discuss 9
                  </Label>
                  <AvField id="stir-case-indicatorDiscuss9" type="text" name="indicatorDiscuss9" />
                </AvGroup>
                <AvGroup>
                  <Label id="indicatorDiscuss10Label" for="stir-case-indicatorDiscuss10">
                    Indicator Discuss 10
                  </Label>
                  <AvField id="stir-case-indicatorDiscuss10" type="text" name="indicatorDiscuss10" />
                </AvGroup>
                <AvGroup>
                  <Label id="indicatorDiscuss11Label" for="stir-case-indicatorDiscuss11">
                    Indicator Discuss 11
                  </Label>
                  <AvField id="stir-case-indicatorDiscuss11" type="text" name="indicatorDiscuss11" />
                </AvGroup>
                <AvGroup>
                  <Label id="indicatorDiscuss12Label" for="stir-case-indicatorDiscuss12">
                    Indicator Discuss 12
                  </Label>
                  <AvField id="stir-case-indicatorDiscuss12" type="text" name="indicatorDiscuss12" />
                </AvGroup>
                <AvGroup>
                  <Label id="decisionLabel" for="stir-case-decision">
                    Decision
                  </Label>
                  <AvField id="stir-case-decision" type="text" name="decision" />
                </AvGroup>
                <AvGroup>
                  <Label id="potentialMitigatingActionsLabel" for="stir-case-potentialMitigatingActions">
                    Potential Mitigating Actions
                  </Label>
                  <AvField id="stir-case-potentialMitigatingActions" type="text" name="potentialMitigatingActions" />
                </AvGroup>
                <AvGroup>
                  <Label id="commentChallengeLabel" for="stir-case-commentChallenge">
                    Comment Challenge
                  </Label>
                  <AvField id="stir-case-commentChallenge" type="text" name="commentChallenge" />
                </AvGroup>
                <AvGroup>
                  <Label id="commentValidateLabel" for="stir-case-commentValidate">
                    Comment Validate
                  </Label>
                  <AvField id="stir-case-commentValidate" type="text" name="commentValidate" />
                </AvGroup>
                <AvGroup>
                  <Label id="entityInfoRCLabel" for="stir-case-entityInfoRC">
                    Entity Info RC
                  </Label>
                  <AvField id="stir-case-entityInfoRC" type="text" name="entityInfoRC" />
                </AvGroup>
                <AvGroup>
                  <Label id="stepInEstimationRCLabel" for="stir-case-stepInEstimationRC">
                    Step In Estimation RC
                  </Label>
                  <AvField id="stir-case-stepInEstimationRC" type="text" name="stepInEstimationRC" />
                </AvGroup>
                <AvGroup>
                  <Label id="impactAnalysisRCLabel" for="stir-case-impactAnalysisRC">
                    Impact Analysis RC
                  </Label>
                  <AvField id="stir-case-impactAnalysisRC" type="text" name="impactAnalysisRC" />
                </AvGroup>
                <AvGroup>
                  <Label id="indicatorAnalysisRCLabel" for="stir-case-indicatorAnalysisRC">
                    Indicator Analysis RC
                  </Label>
                  <AvField id="stir-case-indicatorAnalysisRC" type="text" name="indicatorAnalysisRC" />
                </AvGroup>
                <AvGroup>
                  <Label id="entityBelowBSponsorLabel" for="stir-case-entityBelowBSponsor">
                    Entity Below B Sponsor
                  </Label>
                  <AvField id="stir-case-entityBelowBSponsor" type="text" name="entityBelowBSponsor" />
                </AvGroup>
                <AvGroup>
                  <Label id="isSPELabel" for="stir-case-isSPE">
                    Is SPE
                  </Label>
                  <AvField id="stir-case-isSPE" type="text" name="isSPE" />
                </AvGroup>
                <AvGroup>
                  <Label id="noneOfTheAboveALabel" for="stir-case-noneOfTheAboveA">
                    None Of The Above A
                  </Label>
                  <AvField id="stir-case-noneOfTheAboveA" type="text" name="noneOfTheAboveA" />
                </AvGroup>
                <AvGroup>
                  <Label id="entityBelowBInvestorLabel" for="stir-case-entityBelowBInvestor">
                    Entity Below B Investor
                  </Label>
                  <AvField id="stir-case-entityBelowBInvestor" type="text" name="entityBelowBInvestor" />
                </AvGroup>
                <AvGroup>
                  <Label id="equityHoldingsPerPolicyLabel" for="stir-case-equityHoldingsPerPolicy">
                    Equity Holdings Per Policy
                  </Label>
                  <AvField id="stir-case-equityHoldingsPerPolicy" type="text" name="equityHoldingsPerPolicy" />
                </AvGroup>
                <AvGroup>
                  <Label id="debtHoldingsInScopeLabel" for="stir-case-debtHoldingsInScope">
                    Debt Holdings In Scope
                  </Label>
                  <AvField id="stir-case-debtHoldingsInScope" type="text" name="debtHoldingsInScope" />
                </AvGroup>
                <AvGroup>
                  <Label id="noneOfTheAboveBLabel" for="stir-case-noneOfTheAboveB">
                    None Of The Above B
                  </Label>
                  <AvField id="stir-case-noneOfTheAboveB" type="text" name="noneOfTheAboveB" />
                </AvGroup>
                <AvGroup>
                  <Label id="tier1VendorLabel" for="stir-case-tier1Vendor">
                    Tier 1 Vendor
                  </Label>
                  <AvField id="stir-case-tier1Vendor" type="text" name="tier1Vendor" />
                </AvGroup>
                <AvGroup>
                  <Label id="noneOfTheAboveCLabel" for="stir-case-noneOfTheAboveC">
                    None Of The Above C
                  </Label>
                  <AvField id="stir-case-noneOfTheAboveC" type="text" name="noneOfTheAboveC" />
                </AvGroup>
                <AvGroup>
                  <Label id="entityTypeLabel" for="stir-case-entityType">
                    Entity Type
                  </Label>
                  <AvField id="stir-case-entityType" type="text" name="entityType" />
                </AvGroup>
                <AvGroup>
                  <Label id="entityTypeOtherLabel" for="stir-case-entityTypeOther">
                    Entity Type Other
                  </Label>
                  <AvField id="stir-case-entityTypeOther" type="text" name="entityTypeOther" />
                </AvGroup>
                <AvGroup>
                  <Label id="attachmentLabel" for="stir-case-attachment">
                    Attachment
                  </Label>
                  <AvField id="stir-case-attachment" type="text" name="attachment" />
                </AvGroup>
                <AvGroup>
                  <Label id="attachmentNoCIDLabel" for="stir-case-attachmentNoCID">
                    Attachment No CID
                  </Label>
                  <AvField id="stir-case-attachmentNoCID" type="text" name="attachmentNoCID" />
                </AvGroup>
                <AvGroup>
                  <Label id="attachmentCommentLabel" for="stir-case-attachmentComment">
                    Attachment Comment
                  </Label>
                  <AvField id="stir-case-attachmentComment" type="text" name="attachmentComment" />
                </AvGroup>
                <AvGroup>
                  <Label id="typeOfSupportAnticipatedLabel" for="stir-case-typeOfSupportAnticipated">
                    Type Of Support Anticipated
                  </Label>
                  <AvField id="stir-case-typeOfSupportAnticipated" type="text" name="typeOfSupportAnticipated" />
                </AvGroup>
                <AvGroup>
                  <Label id="instrumentOfTradingOrBankingBookLabel" for="stir-case-instrumentOfTradingOrBankingBook">
                    Instrument Of Trading Or Banking Book
                  </Label>
                  <AvField id="stir-case-instrumentOfTradingOrBankingBook" type="text" name="instrumentOfTradingOrBankingBook" />
                </AvGroup>
                <AvGroup>
                  <Label id="regTreatmentLabel" for="stir-case-regTreatment">
                    Reg Treatment
                  </Label>
                  <AvField id="stir-case-regTreatment" type="text" name="regTreatment" />
                </AvGroup>
                <AvGroup>
                  <Label id="descriptionLabel" for="stir-case-description">
                    Description
                  </Label>
                  <AvField id="stir-case-description" type="text" name="description" />
                </AvGroup>
                <AvGroup>
                  <Label id="accountingIFRSTreatmentLabel" for="stir-case-accountingIFRSTreatment">
                    Accounting IFRS Treatment
                  </Label>
                  <AvField id="stir-case-accountingIFRSTreatment" type="text" name="accountingIFRSTreatment" />
                </AvGroup>
                <AvGroup>
                  <Label id="accountingIFRSTreatmentEquityLabel" for="stir-case-accountingIFRSTreatmentEquity">
                    Accounting IFRS Treatment Equity
                  </Label>
                  <AvField id="stir-case-accountingIFRSTreatmentEquity" type="text" name="accountingIFRSTreatmentEquity" />
                </AvGroup>
                <AvGroup>
                  <Label id="accountingIFRSTreatmentDebtLabel" for="stir-case-accountingIFRSTreatmentDebt">
                    Accounting IFRS Treatment Debt
                  </Label>
                  <AvField id="stir-case-accountingIFRSTreatmentDebt" type="text" name="accountingIFRSTreatmentDebt" />
                </AvGroup>
                <AvGroup>
                  <Label id="totalAssetSizeLabel" for="stir-case-totalAssetSize">
                    Total Asset Size
                  </Label>
                  <AvField id="stir-case-totalAssetSize" type="text" name="totalAssetSize" />
                </AvGroup>
                <AvGroup>
                  <Label id="uncalledCommitmentLabel" for="stir-case-uncalledCommitment">
                    Uncalled Commitment
                  </Label>
                  <AvField id="stir-case-uncalledCommitment" type="text" name="uncalledCommitment" />
                </AvGroup>
                <AvGroup>
                  <Label id="currentAUMLabel" for="stir-case-currentAUM">
                    Current AUM
                  </Label>
                  <AvField id="stir-case-currentAUM" type="text" name="currentAUM" />
                </AvGroup>
                <AvGroup>
                  <Label id="targetAUMLabel" for="stir-case-targetAUM">
                    Target AUM
                  </Label>
                  <AvField id="stir-case-targetAUM" type="text" name="targetAUM" />
                </AvGroup>
                <AvGroup>
                  <Label id="stepInRiskAmountLabel" for="stir-case-stepInRiskAmount">
                    Step In Risk Amount
                  </Label>
                  <AvField id="stir-case-stepInRiskAmount" type="text" name="stepInRiskAmount" />
                </AvGroup>
                <AvGroup>
                  <Label id="contractualExposureInMillionUSDLabel" for="stir-case-contractualExposureInMillionUSD">
                    Contractual Exposure In Million USD
                  </Label>
                  <AvField id="stir-case-contractualExposureInMillionUSD" type="text" name="contractualExposureInMillionUSD" />
                </AvGroup>
                <AvGroup>
                  <Label id="amconf1Label" for="stir-case-amconf1">
                    Amconf 1
                  </Label>
                  <AvField id="stir-case-amconf1" type="text" name="amconf1" />
                </AvGroup>
                <AvGroup>
                  <Label id="amconf2Label" for="stir-case-amconf2">
                    Amconf 2
                  </Label>
                  <AvField id="stir-case-amconf2" type="text" name="amconf2" />
                </AvGroup>
                <AvGroup>
                  <Label id="amconf3Label" for="stir-case-amconf3">
                    Amconf 3
                  </Label>
                  <AvField id="stir-case-amconf3" type="text" name="amconf3" />
                </AvGroup>
                <AvGroup>
                  <Label id="dRRdecisionLabel" for="stir-case-dRRdecision">
                    D R Rdecision
                  </Label>
                  <AvField id="stir-case-dRRdecision" type="text" name="dRRdecision" />
                </AvGroup>
                <AvGroup>
                  <Label id="optionalCommentLabel" for="stir-case-optionalComment">
                    Optional Comment
                  </Label>
                  <AvField id="stir-case-optionalComment" type="text" name="optionalComment" />
                </AvGroup>
                <AvGroup>
                  <Label id="optionalCommentRatiosLabel" for="stir-case-optionalCommentRatios">
                    Optional Comment Ratios
                  </Label>
                  <AvField id="stir-case-optionalCommentRatios" type="text" name="optionalCommentRatios" />
                </AvGroup>
                <AvGroup>
                  <Label id="rejectionRationaleLabel" for="stir-case-rejectionRationale">
                    Rejection Rationale
                  </Label>
                  <AvField id="stir-case-rejectionRationale" type="text" name="rejectionRationale" />
                </AvGroup>
                <AvGroup>
                  <Label id="dueDateLabel" for="stir-case-dueDate">
                    Due Date
                  </Label>
                  <AvField id="stir-case-dueDate" type="text" name="dueDate" />
                </AvGroup>
                <AvGroup>
                  <Label id="caseTypeLabel" for="stir-case-caseType">
                    Case Type
                  </Label>
                  <AvField id="stir-case-caseType" type="text" name="caseType" />
                </AvGroup>
                <AvGroup>
                  <Label id="caseNameLabel" for="stir-case-caseName">
                    Case Name
                  </Label>
                  <AvField id="stir-case-caseName" type="text" name="caseName" />
                </AvGroup>
                <AvGroup>
                  <Label id="endTimeLabel" for="stir-case-endTime">
                    End Time
                  </Label>
                  <AvField id="stir-case-endTime" type="date" className="form-control" name="endTime" />
                </AvGroup>
                <AvGroup>
                  <Label id="caseDueDateLabel" for="stir-case-caseDueDate">
                    Case Due Date
                  </Label>
                  <AvField id="stir-case-caseDueDate" type="text" name="caseDueDate" />
                </AvGroup>
                <AvGroup>
                  <Label id="firstLoDInitiatorLabel" for="stir-case-firstLoDInitiator">
                    First Lo D Initiator
                  </Label>
                  <AvField id="stir-case-firstLoDInitiator" type="text" name="firstLoDInitiator" />
                </AvGroup>
                <AvGroup>
                  <Label id="secondLoDAssigneeLabel" for="stir-case-secondLoDAssignee">
                    Second Lo D Assignee
                  </Label>
                  <AvField id="stir-case-secondLoDAssignee" type="text" name="secondLoDAssignee" />
                </AvGroup>
                <AvGroup>
                  <Label id="ratioAssigneeLabel" for="stir-case-ratioAssignee">
                    Ratio Assignee
                  </Label>
                  <AvField id="stir-case-ratioAssignee" type="text" name="ratioAssignee" />
                </AvGroup>
                <AvGroup>
                  <Label id="drrAssigneeLabel" for="stir-case-drrAssignee">
                    Drr Assignee
                  </Label>
                  <AvField id="stir-case-drrAssignee" type="text" name="drrAssignee" />
                </AvGroup>
                <AvGroup>
                  <Label id="businessKeyLabel" for="stir-case-businessKey">
                    Business Key
                  </Label>
                  <AvField id="stir-case-businessKey" type="text" name="businessKey" />
                </AvGroup>
                <AvGroup>
                  <Label id="initiationDateLabel" for="stir-case-initiationDate">
                    Initiation Date
                  </Label>
                  <AvField id="stir-case-initiationDate" type="text" name="initiationDate" />
                </AvGroup>
                <AvGroup>
                  <Label id="reviewOutcomeLabel" for="stir-case-reviewOutcome">
                    Review Outcome
                  </Label>
                  <AvField id="stir-case-reviewOutcome" type="text" name="reviewOutcome" />
                </AvGroup>
                <AvGroup>
                  <Label id="ubsDivisionLabel" for="stir-case-ubsDivision">
                    Ubs Division
                  </Label>
                  <AvField id="stir-case-ubsDivision" type="text" name="ubsDivision" />
                </AvGroup>
                <AvGroup>
                  <Label id="commentRejectLabel" for="stir-case-commentReject">
                    Comment Reject
                  </Label>
                  <AvField id="stir-case-commentReject" type="text" name="commentReject" />
                </AvGroup>
                <AvGroup>
                  <Label id="rejectOrEscalateLabel" for="stir-case-rejectOrEscalate">
                    Reject Or Escalate
                  </Label>
                  <AvField id="stir-case-rejectOrEscalate" type="text" name="rejectOrEscalate" />
                </AvGroup>
                <AvGroup>
                  <Label id="attachmentEscalationLabel" for="stir-case-attachmentEscalation">
                    Attachment Escalation
                  </Label>
                  <AvField id="stir-case-attachmentEscalation" type="text" name="attachmentEscalation" />
                </AvGroup>
                <AvGroup>
                  <Label id="attachmentEscalationNoCIDLabel" for="stir-case-attachmentEscalationNoCID">
                    Attachment Escalation No CID
                  </Label>
                  <AvField id="stir-case-attachmentEscalationNoCID" type="text" name="attachmentEscalationNoCID" />
                </AvGroup>
                <AvGroup>
                  <Label id="callbackIdLabel" for="stir-case-callbackId">
                    Callback Id
                  </Label>
                  <AvField id="stir-case-callbackId" type="text" name="callbackId" />
                </AvGroup>
                <AvGroup>
                  <Label id="callbackTypeLabel" for="stir-case-callbackType">
                    Callback Type
                  </Label>
                  <AvField id="stir-case-callbackType" type="text" name="callbackType" />
                </AvGroup>
                <AvGroup>
                  <Label id="caseDefinitionIdLabel" for="stir-case-caseDefinitionId">
                    Case Definition Id
                  </Label>
                  <AvField id="stir-case-caseDefinitionId" type="text" name="caseDefinitionId" />
                </AvGroup>
                <AvGroup>
                  <Label id="nameLabel" for="stir-case-name">
                    Name
                  </Label>
                  <AvField id="stir-case-name" type="text" name="name" />
                </AvGroup>
                <AvGroup>
                  <Label id="parentIdLabel" for="stir-case-parentId">
                    Parent Id
                  </Label>
                  <AvField id="stir-case-parentId" type="text" name="parentId" />
                </AvGroup>
                <AvGroup>
                  <Label id="startTimeLabel" for="stir-case-startTime">
                    Start Time
                  </Label>
                  <AvField id="stir-case-startTime" type="date" className="form-control" name="startTime" />
                </AvGroup>
                <AvGroup>
                  <Label id="startUserIdLabel" for="stir-case-startUserId">
                    Start User Id
                  </Label>
                  <AvField id="stir-case-startUserId" type="text" name="startUserId" />
                </AvGroup>
                <AvGroup>
                  <Label id="stateLabel" for="stir-case-state">
                    State
                  </Label>
                  <AvField id="stir-case-state" type="text" name="state" />
                </AvGroup>
                <AvGroup>
                  <Label id="tenantIdLabel" for="stir-case-tenantId">
                    Tenant Id
                  </Label>
                  <AvField id="stir-case-tenantId" type="text" name="tenantId" />
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/stir-case" replace color="info">
                  <FontAwesomeIcon icon="arrow-left" />
                  &nbsp;
                  <span className="d-none d-md-inline">Back</span>
                </Button>
                &nbsp;
                <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                  <FontAwesomeIcon icon="save" />
                  &nbsp; Save
                </Button>
              </AvForm>
            )}
          </Col>
        </Row>
      </div>
    );
  }
}

const mapStateToProps = (storeState: IRootState) => ({
  sTIRCaseEntity: storeState.sTIRCase.entity,
  loading: storeState.sTIRCase.loading,
  updating: storeState.sTIRCase.updating,
  updateSuccess: storeState.sTIRCase.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(STIRCaseUpdate);
