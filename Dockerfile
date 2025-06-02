FROM node:18-bullseye

WORKDIR /app

COPY package*.json ./

RUN npm cache clean --force && \
    npm install --no-optional

COPY . .

EXPOSE 3000
CMD ["npm", "start"]