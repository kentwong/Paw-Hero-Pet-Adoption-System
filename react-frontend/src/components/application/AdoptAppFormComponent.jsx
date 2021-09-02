import React, { Component } from 'react';
import PetService from '../../services/PetService';
import ApplicationService from '../../services/ApplicationService'

class AdoptAppFormComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            petId: this.props.match.params.id,
            pet: {},
            message: '',
            userId: localStorage.getItem("userid")
        }
        this.handleOnChange = this.handleOnChange.bind(this);
        this.addApplication = this.addApplication.bind(this);
    }

    componentDidMount() {
        PetService.getPetById(this.state.petId).then(res => {
            this.setState({ pet: res.data })
        })
    }

    handleOnChange = e => {
        const { id, value } = e.target;
        this.setState({
            [id]: value
        })
    }

    cancel() {
        this.props.history.push('/');
    }

    addApplication = e => {
        e.preventDefault();

        let application = {
            message: this.state.message,
            status: "Pending",
            user: {
                "userId": parseInt(this.state.userId)
            },
            pet: {
                "petId": parseInt(this.state.petId)
            }
        };
        console.log(JSON.stringify(application));

        ApplicationService.createApplication(application).then(res => {
            this.props.history.push('/application/view');
        })

    }

    render() {
        return (
            <div className="container">
                <form className="custom-container" onSubmit={this.addApplication}>
                    <h2 className="mb-5">Pet Adoption Application Form</h2>
                    <h4 className="mb-5 fs-4 badge bg-secondary">💌 Hi {localStorage.getItem("name")}, thanks for adopting {this.state.pet.name}. </h4>

                    <div className="mb-3">
                        <label htmlFor="message" className="form-label">Share a bit about yourself and your home. <span className="text-danger">*</span></label>
                        <textarea className="form-control" id="message" rows="3" value={this.state.message} placeholder={"E.g. I am writing to express my interest in " + this.state.pet.name + ". We have a big, grassy backyard with high fences and plenty of shade. We also have 2 children, aged 4 and 6, who would be wonderful companions to give " + this.state.pet.name + " plenty of love."} onChange={this.handleOnChange} required></textarea>
                    </div>

                    <button type="submit" className="btn btn-primary me-2">Adopt Now</button>
                    <button className="btn btn-danger" onClick={this.cancel.bind(this)}>Cancel</button>
                </form>
            </div>
        );
    }
}

export default AdoptAppFormComponent;