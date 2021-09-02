import React, { Component } from 'react';
import UserService from '../../services/UserService';
import ApplicationService from '../../services/ApplicationService';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTrash } from '@fortawesome/free-solid-svg-icons';

class ProcessApplicationComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            applications: []
        }
    }

    componentDidMount() {
        ApplicationService.getApplications().then((res) => {
            this.setState({ applications: res.data })
        })
    }

    updateApplication = (id, status) => {

        let application = {
            status: status,
        };
        console.log(JSON.stringify((application)));

        ApplicationService.updateApplication(application, id).then(res => {

            ApplicationService.getApplications().then((res) => {
                this.setState({ applications: res.data })
            })
        });
    }

    deleteApplication = (id) => {
        ApplicationService.deleteApplication(id);
        this.setState({ applications: this.state.applications.filter(application => application.applicationId !== id) })
    }

    render() {
        console.log(this.state.applications)
        return (
            <div className="container my-5">
                <h2 className="text-center">Application List</h2>

                <div className="row">
                    <table className="table table-Striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th className="">ID</th>
                                <th className="">Applicant Details</th>
                                <th className="">Pet Details</th>
                                <th className="">Application Message</th>
                                <th className="">Application Date</th>
                                <th className="">Status</th>
                                <th className="">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.applications.map(
                                    application =>
                                        <tr key={application.applicationId}>
                                            <td> {application.applicationId} </td>
                                            <td>
                                                <div>
                                                    {application.user.firstName + ' ' + application.user.lastName} <br />
                                                    {application.user.phone} <br />
                                                    {application.user.emailAddress}
                                                </div>
                                            </td>
                                            <td>
                                                <div>
                                                    {application.pet.name + ' (pet id: ' + application.pet.petId + ')'} <br />
                                                    {application.pet.breed} <br />
                                                    {application.pet.location}
                                                </div>

                                            </td>
                                            <td> {application.message} </td>
                                            <td> {application.date} </td>
                                            <td> {application.status} </td>

                                            <td>
                                                <button onClick={() => this.updateApplication(application.applicationId, "Approved")} className="btn btn-success mb-2 me-2">Approve</button>
                                                <button onClick={() => this.updateApplication(application.applicationId, "Denied")} className="btn btn-danger mb-2 me-2">Deny</button>
                                                <FontAwesomeIcon className="fa-lg bin" icon={faTrash} color="#0d6efd" onClick={() => this.deleteApplication(application.applicationId)} />
                                            </td>
                                        </tr>
                                )
                            }
                        </tbody>

                    </table>
                </div>
            </div>
        );
    }
}

export default ProcessApplicationComponent;