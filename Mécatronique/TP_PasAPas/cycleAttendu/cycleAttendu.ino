#define STEP 2
void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  Serial.println("Debut programme");
  pinMode (STEP, OUTPUT);

// On utilse le timer 1, capable de coder sur 16bits

// Registres :
  bitClear(TCCR1A, WGM10);
  bitClear(TCCR1A, WGM11);
  bitClear(TCCR1B, WGM12);
  bitClear(TCCR1B, WGM13);  

// test diviser frequence quartz par 256 : (011 dans tccr1B)
  bitClear(TCCR1B, CS12);
  bitSet(TCCR1B, CS11);
  bitSet(TCCR1B, CS10);

  TCNT1 = 0;

}

void loop() {
  // put your main code here, to run repeatedly:
    //Maintien(0,7);
    Accelerer(0,30000,25);
    //Maintien(30000, 480);
    Accelerer(30000,60000,25);
    //Maintien(60000, 960);
    Decelerer(60000,30000,25);
    //Maintien(30000,480);
    Decelerer(30000,0,25);
    //Maintien(0,240);
}
// Méthode permettant de maintenir le moteur à une même frequence en fonction d'un nb de pas coeficié
void Maintien(unsigned int freq, int tours){
  for(int i=0; i<tours; i++){
    Impulsion();
    TCNT1 = freq;
    bitSet(TIFR1,TOV1);
    Serial.println(freq);
  }      
}

// Méthode permettant d'augmenter la frequence du moteur entre deux paliers en fonction d'une pente
void Accelerer(unsigned int depart,unsigned int arrivee,int pente){
  int increment = (arrivee - depart)/pente;
  while(depart+increment<arrivee){
    if (bitRead(TIFR1, TOV1) == 1){
      Impulsion();
      TCNT1 = depart;
      bitSet(TIFR1,TOV1);
      Serial.println(depart);
      depart += increment;
    }
  }
}

// Méthode permettant de diminuer la frequence du moteur entre deux paliers en fonction d'une pente
void Decelerer(unsigned int depart,unsigned int arrivee, int pente){
  int increment = (depart - arrivee)/pente;
  while(arrivee+increment<depart){
    if (bitRead(TIFR1, TOV1) == 1){
      Impulsion();
      TCNT1 = depart;
      bitSet(TIFR1,TOV1);
      Serial.println(depart);
      depart -= increment;
    }
  }
}

// Méthode pour envoyer une impulsion au moteur PAP
void Impulsion(){
  digitalWrite(STEP, HIGH);
  delayMicroseconds(600);
  digitalWrite(STEP, LOW);
}
