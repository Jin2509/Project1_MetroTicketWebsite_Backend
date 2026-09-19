# Project1_Metro_BE

Spring Boot backend cho hệ thống Metro Ticket Website.

## Yêu cầu
- Java 17+
- Maven
- Docker Desktop
- PostgreSQL 17 (chạy qua Docker Compose)

## Cấu hình môi trường
1. Copy file `.env.example` sang `.env`
2. Cập nhật các giá trị nếu cần

```bash
copy .env.example .env
```

Ví dụ nội dung `.env`:

```env
POSTGRES_DB=metro_db
POSTGRES_USER=postgres
POSTGRES_PASSWORD=123456
POSTGRES_PORT=5432

```

## Chạy PostgreSQL bằng Docker
Từ thư mục project:

```bash
docker compose up -d
```

Kiểm tra container:

```bash
docker compose ps
```

## Chạy ứng dụng Spring Boot

- Mở project trong IntelliJ / VS Code
- Chạy class `Project1MetroBeApplication`

## Kết nối database
App sẽ kết nối tới:
- Host: `localhost`
- Port: `5432`
- Database: `metro_db`
- Username: `postgres`
- Password: `123456`

## Build project
```bash
./mvnw clean package
```

## Troubleshooting
- Nếu Docker báo port đang dùng: đổi `POSTGRES_PORT` trong `.env`
- Nếu app không kết nối DB: kiểm tra PostgreSQL đang chạy bằng

```bash
docker compose logs postgres
```



