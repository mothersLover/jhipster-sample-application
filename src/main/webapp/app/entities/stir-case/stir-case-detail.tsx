import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './stir-case.reducer';
import { ISTIRCase } from 'app/shared/model/stir-case.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ISTIRCaseDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class STIRCaseDetail extends React.Component<ISTIRCaseDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { sTIRCaseEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            STIRCase [<b>{sTIRCaseEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="entityName">Entity Name</span>
            </dt>
            <dd>{sTIRCaseEntity.entityName}</dd>
            <dt>
              <span id="entity">Entity</span>
            </dt>
            <dd>{sTIRCaseEntity.entity}</dd>
            <dt>
              <span id="lsdbID">Lsdb ID</span>
            </dt>
            <dd>{sTIRCaseEntity.lsdbID}</dd>
            <dt>
              <span id="relationship">Relationship</span>
            </dt>
            <dd>{sTIRCaseEntity.relationship}</dd>
            <dt>
              <span id="vendorRAGstatus">Vendor RA Gstatus</span>
            </dt>
            <dd>{sTIRCaseEntity.vendorRAGstatus}</dd>
            <dt>
              <span id="explanationOfEstimate">Explanation Of Estimate</span>
            </dt>
            <dd>{sTIRCaseEntity.explanationOfEstimate}</dd>
            <dt>
              <span id="repRiskConcerns">Rep Risk Concerns</span>
            </dt>
            <dd>{sTIRCaseEntity.repRiskConcerns}</dd>
            <dt>
              <span id="relationshipDescription">Relationship Description</span>
            </dt>
            <dd>{sTIRCaseEntity.relationshipDescription}</dd>
            <dt>
              <span id="i1na">I 1 Na</span>
            </dt>
            <dd>{sTIRCaseEntity.i1na}</dd>
            <dt>
              <span id="i2na">I 2 Na</span>
            </dt>
            <dd>{sTIRCaseEntity.i2na}</dd>
            <dt>
              <span id="i3na">I 3 Na</span>
            </dt>
            <dd>{sTIRCaseEntity.i3na}</dd>
            <dt>
              <span id="i4na">I 4 Na</span>
            </dt>
            <dd>{sTIRCaseEntity.i4na}</dd>
            <dt>
              <span id="i5na">I 5 Na</span>
            </dt>
            <dd>{sTIRCaseEntity.i5na}</dd>
            <dt>
              <span id="i6na">I 6 Na</span>
            </dt>
            <dd>{sTIRCaseEntity.i6na}</dd>
            <dt>
              <span id="i7na">I 7 Na</span>
            </dt>
            <dd>{sTIRCaseEntity.i7na}</dd>
            <dt>
              <span id="i8na">I 8 Na</span>
            </dt>
            <dd>{sTIRCaseEntity.i8na}</dd>
            <dt>
              <span id="i9na">I 9 Na</span>
            </dt>
            <dd>{sTIRCaseEntity.i9na}</dd>
            <dt>
              <span id="i10na">I 10 Na</span>
            </dt>
            <dd>{sTIRCaseEntity.i10na}</dd>
            <dt>
              <span id="i11na">I 11 Na</span>
            </dt>
            <dd>{sTIRCaseEntity.i11na}</dd>
            <dt>
              <span id="i12na">I 12 Na</span>
            </dt>
            <dd>{sTIRCaseEntity.i12na}</dd>
            <dt>
              <span id="indicatorDiscuss1">Indicator Discuss 1</span>
            </dt>
            <dd>{sTIRCaseEntity.indicatorDiscuss1}</dd>
            <dt>
              <span id="indicatorDiscuss2">Indicator Discuss 2</span>
            </dt>
            <dd>{sTIRCaseEntity.indicatorDiscuss2}</dd>
            <dt>
              <span id="indicatorDiscuss3">Indicator Discuss 3</span>
            </dt>
            <dd>{sTIRCaseEntity.indicatorDiscuss3}</dd>
            <dt>
              <span id="indicatorDiscuss4">Indicator Discuss 4</span>
            </dt>
            <dd>{sTIRCaseEntity.indicatorDiscuss4}</dd>
            <dt>
              <span id="indicatorDiscuss5">Indicator Discuss 5</span>
            </dt>
            <dd>{sTIRCaseEntity.indicatorDiscuss5}</dd>
            <dt>
              <span id="indicatorDiscuss6">Indicator Discuss 6</span>
            </dt>
            <dd>{sTIRCaseEntity.indicatorDiscuss6}</dd>
            <dt>
              <span id="indicatorDiscuss7">Indicator Discuss 7</span>
            </dt>
            <dd>{sTIRCaseEntity.indicatorDiscuss7}</dd>
            <dt>
              <span id="indicatorDiscuss8">Indicator Discuss 8</span>
            </dt>
            <dd>{sTIRCaseEntity.indicatorDiscuss8}</dd>
            <dt>
              <span id="indicatorDiscuss9">Indicator Discuss 9</span>
            </dt>
            <dd>{sTIRCaseEntity.indicatorDiscuss9}</dd>
            <dt>
              <span id="indicatorDiscuss10">Indicator Discuss 10</span>
            </dt>
            <dd>{sTIRCaseEntity.indicatorDiscuss10}</dd>
            <dt>
              <span id="indicatorDiscuss11">Indicator Discuss 11</span>
            </dt>
            <dd>{sTIRCaseEntity.indicatorDiscuss11}</dd>
            <dt>
              <span id="indicatorDiscuss12">Indicator Discuss 12</span>
            </dt>
            <dd>{sTIRCaseEntity.indicatorDiscuss12}</dd>
            <dt>
              <span id="decision">Decision</span>
            </dt>
            <dd>{sTIRCaseEntity.decision}</dd>
            <dt>
              <span id="potentialMitigatingActions">Potential Mitigating Actions</span>
            </dt>
            <dd>{sTIRCaseEntity.potentialMitigatingActions}</dd>
            <dt>
              <span id="commentChallenge">Comment Challenge</span>
            </dt>
            <dd>{sTIRCaseEntity.commentChallenge}</dd>
            <dt>
              <span id="commentValidate">Comment Validate</span>
            </dt>
            <dd>{sTIRCaseEntity.commentValidate}</dd>
            <dt>
              <span id="entityInfoRC">Entity Info RC</span>
            </dt>
            <dd>{sTIRCaseEntity.entityInfoRC}</dd>
            <dt>
              <span id="stepInEstimationRC">Step In Estimation RC</span>
            </dt>
            <dd>{sTIRCaseEntity.stepInEstimationRC}</dd>
            <dt>
              <span id="impactAnalysisRC">Impact Analysis RC</span>
            </dt>
            <dd>{sTIRCaseEntity.impactAnalysisRC}</dd>
            <dt>
              <span id="indicatorAnalysisRC">Indicator Analysis RC</span>
            </dt>
            <dd>{sTIRCaseEntity.indicatorAnalysisRC}</dd>
            <dt>
              <span id="entityBelowBSponsor">Entity Below B Sponsor</span>
            </dt>
            <dd>{sTIRCaseEntity.entityBelowBSponsor}</dd>
            <dt>
              <span id="isSPE">Is SPE</span>
            </dt>
            <dd>{sTIRCaseEntity.isSPE}</dd>
            <dt>
              <span id="noneOfTheAboveA">None Of The Above A</span>
            </dt>
            <dd>{sTIRCaseEntity.noneOfTheAboveA}</dd>
            <dt>
              <span id="entityBelowBInvestor">Entity Below B Investor</span>
            </dt>
            <dd>{sTIRCaseEntity.entityBelowBInvestor}</dd>
            <dt>
              <span id="equityHoldingsPerPolicy">Equity Holdings Per Policy</span>
            </dt>
            <dd>{sTIRCaseEntity.equityHoldingsPerPolicy}</dd>
            <dt>
              <span id="debtHoldingsInScope">Debt Holdings In Scope</span>
            </dt>
            <dd>{sTIRCaseEntity.debtHoldingsInScope}</dd>
            <dt>
              <span id="noneOfTheAboveB">None Of The Above B</span>
            </dt>
            <dd>{sTIRCaseEntity.noneOfTheAboveB}</dd>
            <dt>
              <span id="tier1Vendor">Tier 1 Vendor</span>
            </dt>
            <dd>{sTIRCaseEntity.tier1Vendor}</dd>
            <dt>
              <span id="noneOfTheAboveC">None Of The Above C</span>
            </dt>
            <dd>{sTIRCaseEntity.noneOfTheAboveC}</dd>
            <dt>
              <span id="entityType">Entity Type</span>
            </dt>
            <dd>{sTIRCaseEntity.entityType}</dd>
            <dt>
              <span id="entityTypeOther">Entity Type Other</span>
            </dt>
            <dd>{sTIRCaseEntity.entityTypeOther}</dd>
            <dt>
              <span id="attachment">Attachment</span>
            </dt>
            <dd>{sTIRCaseEntity.attachment}</dd>
            <dt>
              <span id="attachmentNoCID">Attachment No CID</span>
            </dt>
            <dd>{sTIRCaseEntity.attachmentNoCID}</dd>
            <dt>
              <span id="attachmentComment">Attachment Comment</span>
            </dt>
            <dd>{sTIRCaseEntity.attachmentComment}</dd>
            <dt>
              <span id="typeOfSupportAnticipated">Type Of Support Anticipated</span>
            </dt>
            <dd>{sTIRCaseEntity.typeOfSupportAnticipated}</dd>
            <dt>
              <span id="instrumentOfTradingOrBankingBook">Instrument Of Trading Or Banking Book</span>
            </dt>
            <dd>{sTIRCaseEntity.instrumentOfTradingOrBankingBook}</dd>
            <dt>
              <span id="regTreatment">Reg Treatment</span>
            </dt>
            <dd>{sTIRCaseEntity.regTreatment}</dd>
            <dt>
              <span id="description">Description</span>
            </dt>
            <dd>{sTIRCaseEntity.description}</dd>
            <dt>
              <span id="accountingIFRSTreatment">Accounting IFRS Treatment</span>
            </dt>
            <dd>{sTIRCaseEntity.accountingIFRSTreatment}</dd>
            <dt>
              <span id="accountingIFRSTreatmentEquity">Accounting IFRS Treatment Equity</span>
            </dt>
            <dd>{sTIRCaseEntity.accountingIFRSTreatmentEquity}</dd>
            <dt>
              <span id="accountingIFRSTreatmentDebt">Accounting IFRS Treatment Debt</span>
            </dt>
            <dd>{sTIRCaseEntity.accountingIFRSTreatmentDebt}</dd>
            <dt>
              <span id="totalAssetSize">Total Asset Size</span>
            </dt>
            <dd>{sTIRCaseEntity.totalAssetSize}</dd>
            <dt>
              <span id="uncalledCommitment">Uncalled Commitment</span>
            </dt>
            <dd>{sTIRCaseEntity.uncalledCommitment}</dd>
            <dt>
              <span id="currentAUM">Current AUM</span>
            </dt>
            <dd>{sTIRCaseEntity.currentAUM}</dd>
            <dt>
              <span id="targetAUM">Target AUM</span>
            </dt>
            <dd>{sTIRCaseEntity.targetAUM}</dd>
            <dt>
              <span id="stepInRiskAmount">Step In Risk Amount</span>
            </dt>
            <dd>{sTIRCaseEntity.stepInRiskAmount}</dd>
            <dt>
              <span id="contractualExposureInMillionUSD">Contractual Exposure In Million USD</span>
            </dt>
            <dd>{sTIRCaseEntity.contractualExposureInMillionUSD}</dd>
            <dt>
              <span id="amconf1">Amconf 1</span>
            </dt>
            <dd>{sTIRCaseEntity.amconf1}</dd>
            <dt>
              <span id="amconf2">Amconf 2</span>
            </dt>
            <dd>{sTIRCaseEntity.amconf2}</dd>
            <dt>
              <span id="amconf3">Amconf 3</span>
            </dt>
            <dd>{sTIRCaseEntity.amconf3}</dd>
            <dt>
              <span id="dRRdecision">D R Rdecision</span>
            </dt>
            <dd>{sTIRCaseEntity.dRRdecision}</dd>
            <dt>
              <span id="optionalComment">Optional Comment</span>
            </dt>
            <dd>{sTIRCaseEntity.optionalComment}</dd>
            <dt>
              <span id="optionalCommentRatios">Optional Comment Ratios</span>
            </dt>
            <dd>{sTIRCaseEntity.optionalCommentRatios}</dd>
            <dt>
              <span id="rejectionRationale">Rejection Rationale</span>
            </dt>
            <dd>{sTIRCaseEntity.rejectionRationale}</dd>
            <dt>
              <span id="dueDate">Due Date</span>
            </dt>
            <dd>{sTIRCaseEntity.dueDate}</dd>
            <dt>
              <span id="caseType">Case Type</span>
            </dt>
            <dd>{sTIRCaseEntity.caseType}</dd>
            <dt>
              <span id="caseName">Case Name</span>
            </dt>
            <dd>{sTIRCaseEntity.caseName}</dd>
            <dt>
              <span id="endTime">End Time</span>
            </dt>
            <dd>
              <TextFormat value={sTIRCaseEntity.endTime} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="caseDueDate">Case Due Date</span>
            </dt>
            <dd>{sTIRCaseEntity.caseDueDate}</dd>
            <dt>
              <span id="firstLoDInitiator">First Lo D Initiator</span>
            </dt>
            <dd>{sTIRCaseEntity.firstLoDInitiator}</dd>
            <dt>
              <span id="secondLoDAssignee">Second Lo D Assignee</span>
            </dt>
            <dd>{sTIRCaseEntity.secondLoDAssignee}</dd>
            <dt>
              <span id="ratioAssignee">Ratio Assignee</span>
            </dt>
            <dd>{sTIRCaseEntity.ratioAssignee}</dd>
            <dt>
              <span id="drrAssignee">Drr Assignee</span>
            </dt>
            <dd>{sTIRCaseEntity.drrAssignee}</dd>
            <dt>
              <span id="businessKey">Business Key</span>
            </dt>
            <dd>{sTIRCaseEntity.businessKey}</dd>
            <dt>
              <span id="initiationDate">Initiation Date</span>
            </dt>
            <dd>{sTIRCaseEntity.initiationDate}</dd>
            <dt>
              <span id="reviewOutcome">Review Outcome</span>
            </dt>
            <dd>{sTIRCaseEntity.reviewOutcome}</dd>
            <dt>
              <span id="ubsDivision">Ubs Division</span>
            </dt>
            <dd>{sTIRCaseEntity.ubsDivision}</dd>
            <dt>
              <span id="commentReject">Comment Reject</span>
            </dt>
            <dd>{sTIRCaseEntity.commentReject}</dd>
            <dt>
              <span id="rejectOrEscalate">Reject Or Escalate</span>
            </dt>
            <dd>{sTIRCaseEntity.rejectOrEscalate}</dd>
            <dt>
              <span id="attachmentEscalation">Attachment Escalation</span>
            </dt>
            <dd>{sTIRCaseEntity.attachmentEscalation}</dd>
            <dt>
              <span id="attachmentEscalationNoCID">Attachment Escalation No CID</span>
            </dt>
            <dd>{sTIRCaseEntity.attachmentEscalationNoCID}</dd>
            <dt>
              <span id="callbackId">Callback Id</span>
            </dt>
            <dd>{sTIRCaseEntity.callbackId}</dd>
            <dt>
              <span id="callbackType">Callback Type</span>
            </dt>
            <dd>{sTIRCaseEntity.callbackType}</dd>
            <dt>
              <span id="caseDefinitionId">Case Definition Id</span>
            </dt>
            <dd>{sTIRCaseEntity.caseDefinitionId}</dd>
            <dt>
              <span id="name">Name</span>
            </dt>
            <dd>{sTIRCaseEntity.name}</dd>
            <dt>
              <span id="parentId">Parent Id</span>
            </dt>
            <dd>{sTIRCaseEntity.parentId}</dd>
            <dt>
              <span id="startTime">Start Time</span>
            </dt>
            <dd>
              <TextFormat value={sTIRCaseEntity.startTime} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="startUserId">Start User Id</span>
            </dt>
            <dd>{sTIRCaseEntity.startUserId}</dd>
            <dt>
              <span id="state">State</span>
            </dt>
            <dd>{sTIRCaseEntity.state}</dd>
            <dt>
              <span id="tenantId">Tenant Id</span>
            </dt>
            <dd>{sTIRCaseEntity.tenantId}</dd>
          </dl>
          <Button tag={Link} to="/entity/stir-case" replace color="info">
            <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/stir-case/${sTIRCaseEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ sTIRCase }: IRootState) => ({
  sTIRCaseEntity: sTIRCase.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(STIRCaseDetail);
