// Réalise une acceleration :

unsigned int valeur_depart=0;

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

  TCNT1 = 0;
}

void loop() {
  // put your main code here, to run repeatedly:
  if (bitRead(TIFR1, TOV1) == 1)
  {
    TCNT1 = valeur_depart;
    bitSet(TIFR1,TOV1);
    Serial.println(valeur_depart);
    if(valeur_depart<60000){ // si nous ne sommes pas à la frequence max,
      valeur_depart += 1380; // on augmente notre frequence d'environ 4 pourcents
    }
  } 
}
