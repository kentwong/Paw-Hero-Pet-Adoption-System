import React, { Component } from 'react';
import UserService from '../../services/UserService';
import ApplicationService from '../../services/ApplicationService';

class ProcessApplicationComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            applications: []
        }
        this.approve = this.approve.bind(this);
        this.deny = this.deny.bind(this);
    }

    componentDidMount() {
        ApplicationService.getApplications().then((res) => {
            this.setState({ applications: res.data })
        })
    }

    approve(id) {
        ApplicationService.updateApplication(id);
        // this.props.history.push(`/updateuser/${id}`);
    }

    deny(id) {
        UserService.deleteUser(id);
        this.setState({ users: this.state.users.filter(user => user.userId !== id) })
    }

    render() {
        console.log(this.state.applications)
        return (
            <div className="container my-5">
                <h2 className="text-center">Application List</h2>

                <div className="row">
                    <table className="table table-Striped table-bordered">
                        <thead>
                            <tr>
                                <th className="">ID</th>
                                <th className="">Applicant Details</th>
                                <th className="">Pet Details</th>
                                <th className="">Application Message</th>
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
                                            <td> {application.status} </td>

                                            <td>
                                                <button onClick={() => this.approve(application.applicationId)} className="btn btn-success mb-2 me-2">Approve</button>
                                                <button onClick={() => this.deny(application.applicationId)} className="btn btn-danger mb-2 me-2">Deny</button>
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