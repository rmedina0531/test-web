import express from 'express';
import path from 'path';

const app = express();
const PORT = 3000;

// Serve static files (e.g., index.html)
app.use(express.static(path.join(__dirname, '../public')));

// Simple API route
app.get('/hello', (_req, res) => {
  res.send('world');
});

app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
