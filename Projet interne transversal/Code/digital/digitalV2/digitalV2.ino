#include <Adafruit_Fingerprint.h>

SoftwareSerial mySerial(2, 3);
Adafruit_Fingerprint finger = Adafruit_Fingerprint(&mySerial);
int relay1 = 8;
bool lastState = -1;

void setup() {
  // put your setup code here, to run once:
  
  pinMode( relay1, OUTPUT);
  Serial.begin(9600);

  delay(100);

  Serial.println("\n\nAdafruit finger detect test");

  // set the data rate for the sensor serial port

  finger.begin(57600);

  if (finger.verifyPassword()) {
    Serial.println("Found fingerprint sensor!");
  } else {
    Serial.println("Did not find fingerprint sensor :(");
    while (1) { delay(1); }
  }

  Serial.println("Waiting for valid finger...");
}



void loop() {
  // put your main code here, to run repeatedly:

  int id;
  id = getFingerprintIDez();
  if( id == -1 ){ //invalid
    Serial.println("empreinte pas ok");
     if( lastState == 0){
         lastState = -1;
         delay(2000);
     }
  }
  else if( id != -1){ //valid
      Serial.println("Empreinte ok");
      digitalWrite(relay1, HIGH);
      delay(2000);
      digitalWrite(relay1, LOW);
  }
delay(50);            //don't ned to run this at full speed.

}



// returns -1 if failed, otherwise returns ID #

int getFingerprintIDez() {
  uint8_t p = finger.getImage();
  Serial.println(p);
  if( p == 0 ){
     lastState = 0;
  }
  if (p != FINGERPRINT_OK)  return -1;
  p = finger.image2Tz();
  if (p != FINGERPRINT_OK)  return -1;
  p = finger.fingerFastSearch();
  if (p != FINGERPRINT_OK)  return -1;
  lastState = 1;
  // found a match!
  Serial.print("Found ID #"); Serial.print(finger.fingerID); 
  Serial.print(" with confidence of "); Serial.println(finger.confidence);
  return finger.fingerID; 

}
