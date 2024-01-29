Web Crawler
Web crawlers are among the most commonly used systems to aggregate large
amounts of information. For instance, search engines like Google use 
crawlers to collect information from websites; similarly, 
news websites use crawlers to aggregate data sources.

How would you design a modern web crawler?
-------------------------------------------
understanding the working

// seed urls  -> parse -> more links
// SEO related information / title / store the parsed information somewhere 
// explore the web -> store the data 
// not part of crawler service - the parsed information will be indexed in something similar to elastic search (inverse indexes)

------------------------
REQ gathering 
crawling strateggy
  DFS (cycle detection)
robot checks
  if a seed url has bombarded a ton of pages, raise alrms 
  (can be a false alarm - Tz - dynamic landing pages)
Duplicate content handling
  digests / fingerprints / checksum ...
handling dynamic content
  crawler must be javasciprt enabled
Data extraction
Data Storage
update mechanism
  dynamic (depends on each seed URL) - Ures's responsibility to define the period
-----------------------
SCALE estimation
2M seed URLs
new seed url/day = 10k 
total tenure = 10 Year
PRATO Principle
20% - 400k seed urls to scan daily
For each seed url - we have avg 20 pages
each page size is 1 MB

400,000 seeds x 20 pages x 1 MB = 8 TB/day data

extracted information we need to store 10% = 800GB
800 x 3650 days = 3000 TB = 3 PB

=> SHARDING IS MUST

write load
800,000 / 86400  = 1MB/sec 

------------------------------
NON FUNCTIONAL REQ / DESIGN GOALS

available - is not a big concern
consistancy - is not big concern
pool of tab-less browsers - to crawl - 8 tb/day => 10MB/sec
for exception handling, simply recrawl the seed url.
put a message queue (kafka) with a queing service (to check db timestamps and updation SLAs) for last 7 days (every 1 hour)

----------------------

// Google search :
// shoes -> 
// web crawler -> explores the internet/ web pages 
// indexer -> [HM]