import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { ICrudGetAllAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './stir-case.reducer';
import { ISTIRCase } from 'app/shared/model/stir-case.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ISTIRCaseProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export class STIRCase extends React.Component<ISTIRCaseProps> {
  componentDidMount() {
    this.props.getEntities();
  }

  render() {
    const { sTIRCaseList, match } = this.props;
    return (
      <div>
        <h2 id="stir-case-heading">
          STIR Cases
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />
            &nbsp; Create a new STIR Case
          </Link>
        </h2>
        <div className="table-responsive">
          {sTIRCaseList && sTIRCaseList.length > 0 ? (
            <Table responsive aria-describedby="stir-case-heading">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Entity Name</th>
                  <th>Entity</th>
                  <th>Lsdb ID</th>
                  <th>Relationship</th>
                  <th>Vendor RA Gstatus</th>
                  <th>Explanation Of Estimate</th>
                  <th>Rep Risk Concerns</th>
                  <th>Relationship Description</th>
                  <th>I 1 Na</th>
                  <th>I 2 Na</th>
                  <th>I 3 Na</th>
                  <th>I 4 Na</th>
                  <th>I 5 Na</th>
                  <th>I 6 Na</th>
                  <th>I 7 Na</th>
                  <th>I 8 Na</th>
                  <th>I 9 Na</th>
                  <th>I 10 Na</th>
                  <th>I 11 Na</th>
                  <th>I 12 Na</th>
                  <th>Indicator Discuss 1</th>
                  <th>Indicator Discuss 2</th>
                  <th>Indicator Discuss 3</th>
                  <th>Indicator Discuss 4</th>
                  <th>Indicator Discuss 5</th>
                  <th>Indicator Discuss 6</th>
                  <th>Indicator Discuss 7</th>
                  <th>Indicator Discuss 8</th>
                  <th>Indicator Discuss 9</th>
                  <th>Indicator Discuss 10</th>
                  <th>Indicator Discuss 11</th>
                  <th>Indicator Discuss 12</th>
                  <th>Decision</th>
                  <th>Potential Mitigating Actions</th>
                  <th>Comment Challenge</th>
                  <th>Comment Validate</th>
                  <th>Entity Info RC</th>
                  <th>Step In Estimation RC</th>
                  <th>Impact Analysis RC</th>
                  <th>Indicator Analysis RC</th>
                  <th>Entity Below B Sponsor</th>
                  <th>Is SPE</th>
                  <th>None Of The Above A</th>
                  <th>Entity Below B Investor</th>
                  <th>Equity Holdings Per Policy</th>
                  <th>Debt Holdings In Scope</th>
                  <th>None Of The Above B</th>
                  <th>Tier 1 Vendor</th>
                  <th>None Of The Above C</th>
                  <th>Entity Type</th>
                  <th>Entity Type Other</th>
                  <th>Attachment</th>
                  <th>Attachment No CID</th>
                  <th>Attachment Comment</th>
                  <th>Type Of Support Anticipated</th>
                  <th>Instrument Of Trading Or Banking Book</th>
                  <th>Reg Treatment</th>
                  <th>Description</th>
                  <th>Accounting IFRS Treatment</th>
                  <th>Accounting IFRS Treatment Equity</th>
                  <th>Accounting IFRS Treatment Debt</th>
                  <th>Total Asset Size</th>
                  <th>Uncalled Commitment</th>
                  <th>Current AUM</th>
                  <th>Target AUM</th>
                  <th>Step In Risk Amount</th>
                  <th>Contractual Exposure In Million USD</th>
                  <th>Amconf 1</th>
                  <th>Amconf 2</th>
                  <th>Amconf 3</th>
                  <th>D R Rdecision</th>
                  <th>Optional Comment</th>
                  <th>Optional Comment Ratios</th>
                  <th>Rejection Rationale</th>
                  <th>Due Date</th>
                  <th>Case Type</th>
                  <th>Case Name</th>
                  <th>End Time</th>
                  <th>Case Due Date</th>
                  <th>First Lo D Initiator</th>
                  <th>Second Lo D Assignee</th>
                  <th>Ratio Assignee</th>
                  <th>Drr Assignee</th>
                  <th>Business Key</th>
                  <th>Initiation Date</th>
                  <th>Review Outcome</th>
                  <th>Ubs Division</th>
                  <th>Comment Reject</th>
                  <th>Reject Or Escalate</th>
                  <th>Attachment Escalation</th>
                  <th>Attachment Escalation No CID</th>
                  <th>Callback Id</th>
                  <th>Callback Type</th>
                  <th>Case Definition Id</th>
                  <th>Name</th>
                  <th>Parent Id</th>
                  <th>Start Time</th>
                  <th>Start User Id</th>
                  <th>State</th>
                  <th>Tenant Id</th>
                  <th />
                </tr>
              </thead>
              <tbody>
                {sTIRCaseList.map((sTIRCase, i) => (
                  <tr key={`entity-${i}`}>
                    <td>
                      <Button tag={Link} to={`${match.url}/${sTIRCase.id}`} color="link" size="sm">
                        {sTIRCase.id}
                      </Button>
                    </td>
                    <td>{sTIRCase.entityName}</td>
                    <td>{sTIRCase.entity}</td>
                    <td>{sTIRCase.lsdbID}</td>
                    <td>{sTIRCase.relationship}</td>
                    <td>{sTIRCase.vendorRAGstatus}</td>
                    <td>{sTIRCase.explanationOfEstimate}</td>
                    <td>{sTIRCase.repRiskConcerns}</td>
                    <td>{sTIRCase.relationshipDescription}</td>
                    <td>{sTIRCase.i1na}</td>
                    <td>{sTIRCase.i2na}</td>
                    <td>{sTIRCase.i3na}</td>
                    <td>{sTIRCase.i4na}</td>
                    <td>{sTIRCase.i5na}</td>
                    <td>{sTIRCase.i6na}</td>
                    <td>{sTIRCase.i7na}</td>
                    <td>{sTIRCase.i8na}</td>
                    <td>{sTIRCase.i9na}</td>
                    <td>{sTIRCase.i10na}</td>
                    <td>{sTIRCase.i11na}</td>
                    <td>{sTIRCase.i12na}</td>
                    <td>{sTIRCase.indicatorDiscuss1}</td>
                    <td>{sTIRCase.indicatorDiscuss2}</td>
                    <td>{sTIRCase.indicatorDiscuss3}</td>
                    <td>{sTIRCase.indicatorDiscuss4}</td>
                    <td>{sTIRCase.indicatorDiscuss5}</td>
                    <td>{sTIRCase.indicatorDiscuss6}</td>
                    <td>{sTIRCase.indicatorDiscuss7}</td>
                    <td>{sTIRCase.indicatorDiscuss8}</td>
                    <td>{sTIRCase.indicatorDiscuss9}</td>
                    <td>{sTIRCase.indicatorDiscuss10}</td>
                    <td>{sTIRCase.indicatorDiscuss11}</td>
                    <td>{sTIRCase.indicatorDiscuss12}</td>
                    <td>{sTIRCase.decision}</td>
                    <td>{sTIRCase.potentialMitigatingActions}</td>
                    <td>{sTIRCase.commentChallenge}</td>
                    <td>{sTIRCase.commentValidate}</td>
                    <td>{sTIRCase.entityInfoRC}</td>
                    <td>{sTIRCase.stepInEstimationRC}</td>
                    <td>{sTIRCase.impactAnalysisRC}</td>
                    <td>{sTIRCase.indicatorAnalysisRC}</td>
                    <td>{sTIRCase.entityBelowBSponsor}</td>
                    <td>{sTIRCase.isSPE}</td>
                    <td>{sTIRCase.noneOfTheAboveA}</td>
                    <td>{sTIRCase.entityBelowBInvestor}</td>
                    <td>{sTIRCase.equityHoldingsPerPolicy}</td>
                    <td>{sTIRCase.debtHoldingsInScope}</td>
                    <td>{sTIRCase.noneOfTheAboveB}</td>
                    <td>{sTIRCase.tier1Vendor}</td>
                    <td>{sTIRCase.noneOfTheAboveC}</td>
                    <td>{sTIRCase.entityType}</td>
                    <td>{sTIRCase.entityTypeOther}</td>
                    <td>{sTIRCase.attachment}</td>
                    <td>{sTIRCase.attachmentNoCID}</td>
                    <td>{sTIRCase.attachmentComment}</td>
                    <td>{sTIRCase.typeOfSupportAnticipated}</td>
                    <td>{sTIRCase.instrumentOfTradingOrBankingBook}</td>
                    <td>{sTIRCase.regTreatment}</td>
                    <td>{sTIRCase.description}</td>
                    <td>{sTIRCase.accountingIFRSTreatment}</td>
                    <td>{sTIRCase.accountingIFRSTreatmentEquity}</td>
                    <td>{sTIRCase.accountingIFRSTreatmentDebt}</td>
                    <td>{sTIRCase.totalAssetSize}</td>
                    <td>{sTIRCase.uncalledCommitment}</td>
                    <td>{sTIRCase.currentAUM}</td>
                    <td>{sTIRCase.targetAUM}</td>
                    <td>{sTIRCase.stepInRiskAmount}</td>
                    <td>{sTIRCase.contractualExposureInMillionUSD}</td>
                    <td>{sTIRCase.amconf1}</td>
                    <td>{sTIRCase.amconf2}</td>
                    <td>{sTIRCase.amconf3}</td>
                    <td>{sTIRCase.dRRdecision}</td>
                    <td>{sTIRCase.optionalComment}</td>
                    <td>{sTIRCase.optionalCommentRatios}</td>
                    <td>{sTIRCase.rejectionRationale}</td>
                    <td>{sTIRCase.dueDate}</td>
                    <td>{sTIRCase.caseType}</td>
                    <td>{sTIRCase.caseName}</td>
                    <td>
                      <TextFormat type="date" value={sTIRCase.endTime} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>{sTIRCase.caseDueDate}</td>
                    <td>{sTIRCase.firstLoDInitiator}</td>
                    <td>{sTIRCase.secondLoDAssignee}</td>
                    <td>{sTIRCase.ratioAssignee}</td>
                    <td>{sTIRCase.drrAssignee}</td>
                    <td>{sTIRCase.businessKey}</td>
                    <td>{sTIRCase.initiationDate}</td>
                    <td>{sTIRCase.reviewOutcome}</td>
                    <td>{sTIRCase.ubsDivision}</td>
                    <td>{sTIRCase.commentReject}</td>
                    <td>{sTIRCase.rejectOrEscalate}</td>
                    <td>{sTIRCase.attachmentEscalation}</td>
                    <td>{sTIRCase.attachmentEscalationNoCID}</td>
                    <td>{sTIRCase.callbackId}</td>
                    <td>{sTIRCase.callbackType}</td>
                    <td>{sTIRCase.caseDefinitionId}</td>
                    <td>{sTIRCase.name}</td>
                    <td>{sTIRCase.parentId}</td>
                    <td>
                      <TextFormat type="date" value={sTIRCase.startTime} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>{sTIRCase.startUserId}</td>
                    <td>{sTIRCase.state}</td>
                    <td>{sTIRCase.tenantId}</td>
                    <td className="text-right">
                      <div className="btn-group flex-btn-group-container">
                        <Button tag={Link} to={`${match.url}/${sTIRCase.id}`} color="info" size="sm">
                          <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${sTIRCase.id}/edit`} color="primary" size="sm">
                          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${sTIRCase.id}/delete`} color="danger" size="sm">
                          <FontAwesomeIcon icon="trash" /> <span className="d-none d-md-inline">Delete</span>
                        </Button>
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
          ) : (
            <div className="alert alert-warning">No STIR Cases found</div>
          )}
        </div>
      </div>
    );
  }
}

const mapStateToProps = ({ sTIRCase }: IRootState) => ({
  sTIRCaseList: sTIRCase.entities
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(STIRCase);
