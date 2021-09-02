import React, { Component } from 'react';
import UserService from '../../services/UserService';
import ApplicationService from '../../services/ApplicationService';

class ViewApplicationComponent extends Component {
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

    deny(id) {
        UserService.deleteUser(id);
        this.setState({ applications: this.state.applications.filter(user => user.userId !== id) })
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
                                <th className="">Application Date</th>
                                <th className="">Pet Details</th>
                                <th className="">Application Message</th>
                                <th className="">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.applications.map(
                                    application =>
                                        <tr key={application.applicationId}>
                                            <td> {application.applicationId} </td>
                                            <td> {application.date} </td>
                                            <td>
                                                <div>
                                                    {application.pet.name + ' (pet id: ' + application.pet.petId + ')'} <br />
                                                    {application.pet.breed} <br />
                                                    {application.pet.location}
                                                </div>

                                            </td>
                                            <td> {application.message} </td>

                                            {application.status === "Pending" ?
                                                <td><div className="badge rounded-pill bg-primary">{application.status}</div></td>
                                                : application.status === "Approved" ?
                                                    <td><div className="badge rounded-pill bg-success">{application.status}</div></td>
                                                    : <td><div className="badge rounded-pill bg-danger">{application.status}</div></td>
                                            }

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

export default ViewApplicationComponent;