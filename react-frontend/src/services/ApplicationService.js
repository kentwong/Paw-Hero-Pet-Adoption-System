import axios from 'axios';

const PET_APPLICATION_URL = "http://localhost:8081/pawhero/application";

class ApplicationService {
    getApplications() {
        return axios.get(PET_APPLICATION_URL + '/all');
    }

    createApplication(pet) {
        return axios.post(PET_APPLICATION_URL + '/create', pet);
    }

    getApplicationsByUserId(userId) {
        return axios.get(PET_APPLICATION_URL + '/all/' + userId)
    }

    updateApplication(application, applicationId) {
        return axios.put(PET_APPLICATION_URL + '/update/' + applicationId, application);
    }

    deleteApplication(applicationId) {
        return axios.delete(PET_APPLICATION_URL + '/delete/' + applicationId);
    }
}

export default new ApplicationService();