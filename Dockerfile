FROM node:18-bullseye

WORKDIR /app

COPY package*.json ./

RUN npm cache clean --force && \
    npm install --no-optional

#Copy source
COPY . .

# Expose the port your app runs on
EXPOSE 3000

# Start the app
CMD ["npx", "ts-node-dev", "src/server.ts"]