FROM node:latest as builder

RUN mkdir -p /app
WORKDIR /app

COPY . .

RUN npm ci
EXPOSE 4200

CMD ["npm", "start"]