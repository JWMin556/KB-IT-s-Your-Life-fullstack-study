class Pet {
  constructor(
    name,
    species,
    vaccinations = [],
    healthCheckDate = null,
    alreadyWarned = false
  ) {
    this.name = name;
    this.species = species;
    this.vaccinations = vaccinations;
    this.healthCheckDate = healthCheckDate;
    this.alreadyWarned = alreadyWarned;
  }

  printPetInfo() {
    console.log(
      `[등록] ${this.species} - ${
        this.name
      } (예방접종: [${this.vaccinations.join(', ')}], 건강검진: ${
        this.healthCheckDate || '미등록'
      })`
    );
  }

  addVaccination(disease) {
    if (this.vaccinations.includes(disease)) {
      console.log(
        `[예방접종 중복] ${this.species}: ${disease}은(는) 이미 등록되어 있습니다.`
      );
    } else {
      this.vaccinations.push(disease);
      console.log(
        `[예방접종 추가] ${this.species}: ${disease} 예방접종이 추가되었습니다.`
      );
    }
  }

  updateHealthCheckDate(newDate) {
    this.healthCheckDate = newDate;
    this.alreadyWarned = false; // 새로운 건강검진 날짜가 업데이트되면 경고를 초기화
    console.log(
      `[건강검진 업데이트] ${this.species}: ${
        newDate.toISOString().split('T')[0]
      }`
    );
  }

  // 건강검진 날짜가 1년 이상 경과한 경우 경고를 출력
  checkHealthWarning() {
    const currentDate = new Date();
    const lastCheckDate = new Date(this.healthCheckDate);

    // 1년이 경과한 경우 경고를 출력하고, 이미 경고한 경우 경고를 다시 출력하지 않음
    if (
      currentDate - lastCheckDate >= 365 * 24 * 60 * 60 * 1000 &&
      !this.alreadyWarned
    ) {
      console.log(
        `[건강검진 경고] ${this.name}: 1년 이상 건강검진을 받지 않았습니다!`
      );
      this.alreadyWarned = true; // 경고를 출력했으므로 이후에는 출력하지 않음
    }
  }
}

class PetHealthManager {
  constructor() {
    this.pets = [];
  }

  registerPet(pet) {
    this.pets.push(pet);
    pet.printPetInfo();
  }

  checkHealthStatus() {
    // 10초 후에 검사 종료 메시지를 출력
    const timeout = setTimeout(() => {
      console.log('[검사 종료]');
    }, 10000);

    // 3초마다 펫의 건강 상태를 검사
    const interval = setInterval(() => {
      this.pets.forEach((pet) => {
        pet.checkHealthWarning(); // 각 펫에 대해 건강검진 경고 확인
      });
    }, 3000);

    // 10초 후에 검사 종료
    setTimeout(() => {
      clearInterval(interval); // 10초 후에 검사를 종료합니다.
    }, 10000);
  }
}

// 🐾 시스템 사용 예시
const manager = new PetHealthManager();

// 펫 등록
const pet1 = new Pet('나비', '고양이', ['종합백신'], new Date('2023-03-10'));
manager.registerPet(pet1);

// 예방접종 추가
pet1.addVaccination('광견병');
pet1.addVaccination('광견병'); // 중복 테스트

// 건강 상태 검사 시작
manager.checkHealthStatus();

// 5초 후 건강검진 업데이트 (경고 초기화 테스트)
setTimeout(() => {
  pet1.updateHealthCheckDate(new Date()); // 건강검진 날짜 업데이트
}, 5000);
