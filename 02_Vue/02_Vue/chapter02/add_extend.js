class Vehicle {
  constructor(name, wheel) {
    this.name = name;
    this.wheel = wheel;
  }
}

const myVehicle = new Vehicle('운송수단', 2);
console.log(myVehicle);

class Bicycle extends Vehicle {
  constructor(name, wheel, color) {
    super(name, wheel); // super 키워드로 부모 클래스를 호출가능
    this.color = color;
  }
}

const myBike = new Bicycle('자전거', 4, 'red');
console.log(myBike);
