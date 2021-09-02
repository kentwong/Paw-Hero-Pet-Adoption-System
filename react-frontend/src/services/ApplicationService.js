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

    // updatePet(pet, petId) {
    //     return axios.put(PET_API_BASE_URL + '/' + petId, pet);
    // }

    // deletePet(petId) {
    //     return axios.delete(PET_API_BASE_URL + '/' + petId);
    // }
}

export default new ApplicationService();