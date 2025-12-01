-- PostgreSQL schema for Cafe app
CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  full_name VARCHAR(100),
  email VARCHAR(100) UNIQUE,
  role VARCHAR(20) NOT NULL DEFAULT 'USER',
  loyalty_points INTEGER DEFAULT 0,
  blocked BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS menu_items (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  description TEXT,
  price NUMERIC(10,2) NOT NULL,
  available BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS orders (
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(id) ON DELETE SET NULL,
  time_requested TIMESTAMP,
  created_at TIMESTAMP DEFAULT now(),
  total NUMERIC(10,2) NOT NULL,
  paid BOOLEAN DEFAULT FALSE,
  status VARCHAR(30) DEFAULT 'NEW'
);

CREATE TABLE IF NOT EXISTS order_items (
  id SERIAL PRIMARY KEY,
  order_id INTEGER REFERENCES orders(id) ON DELETE CASCADE,
  menu_item_id INTEGER REFERENCES menu_items(id),
  quantity INTEGER DEFAULT 1,
  price NUMERIC(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS reviews (
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(id) ON DELETE SET NULL,
  order_id INTEGER REFERENCES orders(id) ON DELETE SET NULL,
  rating INTEGER CHECK (rating >=1 AND rating <=5),
  comment TEXT,
  created_at TIMESTAMP DEFAULT now()
);
