# VELLORA — Your Personal World of Books

VELLORA is a premium dark-themed digital library and reading-management prototype built as a Java DSA academic project.

## Features
- Personal book collection with search, filters, shelf/rack locations and availability.
- Add, edit and remove books; duplicate ISBN prevention.
- Book cover upload and browser OCR using Tesseract.js, with manual-entry fallback.
- FIFO return-processing queue.
- Popularity ranking using a Max Heap concept.
- DSA Studio explaining Hash Table, BST, Queue, Max Heap and HashSet.
- Actual Java implementations in `java/`.

## Run the website
This is a static frontend. You can open `index.html` directly, but using a local server is recommended:
1. Open this folder in VS Code.
2. Run with the Live Server extension, or use `python -m http.server 5500`.
3. Visit `http://localhost:5500`.

No frontend build step is required.

## Run the Java DSA demonstration
Requires JDK 17 or later.

From the project root:

```bash
javac java/*.java
java -cp java Main
```

## Deploy to Vercel
1. Push the repository to GitHub.
2. Import the repository into Vercel.
3. Set Framework Preset to **Other**.
4. Set Root Directory to the repository root.
5. Leave Build Command and Output Directory empty (or use `.` as output directory if requested).
6. Deploy.

The Java files are academic source code and are not executed by Vercel. The deployed static web application uses equivalent browser-side behavior for interactive demonstrations.

## External services and limitations
- Tesseract.js OCR runs in the browser and may not identify every cover or ISBN.
- - No retailer price scraping or invented prices are used.
- Data is stored in browser LocalStorage for this prototype. It is local to the browser/device and is not a multi-user cloud database.

## DSA concepts
| Structure | VELLORA use | Typical complexity |
|---|---|---|
| Hash Table | ISBN lookup | Average O(1) lookup |
| Binary Search Tree | Sorted book records | Average O(log n), worst O(n) |
| Queue | Returned-book processing | O(1) enqueue/dequeue |
| Max Heap | Most-requested books | O(log n) insertion/extraction |
| HashSet | Duplicate ISBN detection | Average O(1) contains |

## Screenshots
Add screenshots of the dashboard, library, reading tracker, scanner and DSA Studio here before final submission.


## Recent enhancements
- Removed the Discover Books catalogue/search experience and its navigation entry.
- Added a Reading Tracker with reading status, page-level progress, completion totals, and an annual reading goal.
- Added CSV export for the personal library.
- Reading progress and goals are stored locally in the browser using localStorage.
