import {Pet} from './Pet.js';

export class PetPhoto extends Pet {
    constructor(name, species, adoptionDate, photoPath) {
        super(name, species, adoptionDate);
        this.photoPath = photoPath;
        this.uploadDate = new Date().toISOString(); // 현재 날짜를 uploadDate로 설정
        this.type = 'Photo';
    }
}
