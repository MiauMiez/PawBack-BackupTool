# 📁 PawBack– Mein eigenes Backup-System mit GUI

Ein einfaches, modulares Tool zur automatisierten Sicherung von Dateien und Ordnern.
Besteht aus einer benutzerfreundlichen GUI-Anwendung und einem Hintergrunddienst, der beim Systemstart ausgeführt wird.


## 🔧 Funktionen
- Erstellung und Verwaltung von Backup-Konfigurationen (Configs)
- GUI zum Festlegen von Ordnern, Dateien, Zeitpunkten
- Hintergrundprozess für automatische Sicherungen beim Systemstart
- Protokollierung aller Sicherungsvorgänge


## 🧠 Funktionsweise
**GUI Anwendung:**  
  
<img src="https://github.com/MiauMiez/PawBack-BackupTool/blob/4cf6d28a2c2513c5d58d105774006921c17ed8fd/other/home.png?raw=true" width="500"/>







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



