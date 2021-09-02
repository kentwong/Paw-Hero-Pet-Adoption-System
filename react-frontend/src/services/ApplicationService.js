import axios from 'axios';

const PET_APPLICATION_URL = "http://localhost:8081/pawhero/application";

class ApplicationService {
    getApplications() {
        return axios.get(PET_APPLICATION_URL + '/all');
    }

    createApplication(pet) {
        return axios.post(PET_APPLICATION_URL + '/create', pet);
    }

    // getPetById(petId) {
    //     return axios.get(PET_API_BASE_URL + '/' + petId);
    // }

    updateApplication(application, applicationId) {
        return axios.put(PET_APPLICATION_URL + '/update/' + applicationId, application);
    }

    // deletePet(petId) {
    //     return axios.delete(PET_API_BASE_URL + '/' + petId);
    // }
}

export default new ApplicationService();