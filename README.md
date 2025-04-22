# 📁 PawBack– Mein eigenes Backup-System mit GUI

Ein einfaches, modulares Tool zur automatisierten Sicherung von Dateien und Ordnern.
Besteht aus einer benutzerfreundlichen GUI-Anwendung und einem Hintergrunddienst, der beim Systemstart ausgeführt wird.


## 🔧 Funktionen
- Erstellung und Verwaltung von Backup-Konfigurationen (Configs)
- GUI zum Festlegen von Ordnern, Dateien, Zeitpunkten
- Hintergrundprozess für automatische Sicherungen beim Systemstart
- Protokollierung aller Sicherungsvorgänge


## 🧠 Funktionsweise
  
<img src="https://github.com/MiauMiez/PawBack-BackupTool/blob/4cf6d28a2c2513c5d58d105774006921c17ed8fd/other/home.png?raw=true" width="500"/>
<img src="https://github.com/MiauMiez/PawBack-BackupTool/blob/9021b019f3061c035d5508ed10d0784ae4efab09/other/editor_creator.png" width="500"/>

<details>
<summary>Funktionsweise</summary>
Beim ersten Start erstellt das Programm automatisch einen Ordner im Benutzerverzeichnis des aktuellen Windows-Nutzers.

Über die grafische Oberfläche kann der Nutzer dann eine neue Config (Konfiguration) anlegen. Dazu vergibt er zunächst einen Namen und wählt aus, ob das Backup täglich, wöchentlich oder monatlich durchgeführt werden soll. Anschließend kann er mit dem integrierten Dateiauswahldialog (File Chooser) den gewünschten Ordner oder die Datei für die Sicherung auswählen. Mit einem Klick auf „Continue“ werden alle Eingaben überprüft, zum Beispiel, ob der Pfad existiert und alle Felder korrekt ausgefüllt wurden.

Sind die Eingaben gültig, wird die Konfiguration als .json-Datei gespeichert. Um doppelte Dateinamen zu vermeiden, wird zusätzlich ein zufälliger String an den Dateinamen angehängt.

Der Hintergrunddienst prüft beim Systemstart, ob Sicherungen anstehen. Dazu schaut er sich den Zeitstempel next_date in jeder Config an und entscheidet, ob heute ein Backup durchgeführt werden soll.

Configs können jederzeit über den  Config-Editor bearbeitet oder gelöscht werden. Dort werden alle vorhandenen Konfigurationen übersichtlich in einer Tabelle angezeigt.

</details>


## 📂 Beispiel-Config
```json
{
   "created":"2025-04-22",
   "name":"Dokumente",
   "backup_mode":2,
   "folder_file_location":"C:\\Users\\alexa\\Documents",
   "backup_location":"D:\\Seagate\\Backups\\Docs",
   "next_date":"2025-04-29"
}
```
## 🌱 Zukünftige Ideen & Erweiterungen
-  **Wiederherstellungsfunktion**  
  Dateien oder Ordner aus Backups gezielt wiederherstellen
 - **Automatische Updates**  
  Das Programm kann sich selbst aktualisieren oder auf Updates prüfen (Konzept steht schon)
 - **Detailierte Log-Analyse**  
  Grafische Auswertung der älteren Backups

  

