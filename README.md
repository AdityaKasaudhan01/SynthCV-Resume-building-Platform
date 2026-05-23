# SynthCV

A free resume builder web application with a Spring Boot backend.

## Project Structure

```
SynthCV/
├── frontend/
│   ├── assets/
│   │   ├── css/          # All stylesheets
│   │   ├── js/           # All JavaScript files
│   │   └── images/       # All images and logos
│   └── pages/
│       ├── sections/     # Resume section pages (skills, education, etc.)
│       └── *.html        # Main pages (index, login, jobs, etc.)
├── backend/              # Spring Boot application
│   ├── .mvn/wrapper/     # Maven wrapper (no Maven install needed)
│   ├── src/main/
│   │   ├── java/com/synthcv/auth/
│   │   └── resources/
│   ├── mvnw.cmd
│   └── pom.xml
├── database/
│   └── users.db          # SQLite database
└── .gitignore
```

## Running the Backend

> Requires Java 17+

```bash
cd backend
mvnw.cmd spring-boot:run
```

Server starts at: http://localhost:3000
