// Ecrivez le sketch qui montre la réponse à l’interruption du timer.

void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  Serial.println("Debut programme");
// On utilse le timer 1, capable de coder sur 16bits

// Registres :
  bitClear(TCCR1A, WGM10);
  bitClear(TCCR1A, WGM11);
  bitClear(TCCR1B, WGM12);
  bitClear(TCCR1B, WGM13);  

// test diviser frequence quartz par 256 : (011 dans tccr1B)
  bitSet(TCCR1B, CS12);
  bitClear(TCCR1B, CS11);
  bitClear(TCCR1B, CS10);

}

void loop() {
  // put your main code here, to run repeatedly:
  if (bitRead(TIFR1, TOV1) == 1)
  {
    bitSet(TIFR1,TOV1);
    Serial.println("reponse à l'interuption du timer");
  } 
}
