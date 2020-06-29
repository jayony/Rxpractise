package com.example.rxpractise.response;

import java.util.List;

public class ResponseMyCar extends ResponeData {
    private int total;
    private List<BooksEntity> books;
    private String updated_at;
    private int user_id;
    private int count;
    private String created_at;
    private int id;
    private int version;

    public void setTotal(int total) {
        this.total = total;
    }

    public void setBooks(List<BooksEntity> books) {
        this.books = books;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getTotal() {
        return total;
    }

    public List<BooksEntity> getBooks() {
        return books;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getCount() {
        return count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public class BooksEntity {
        /**
         * large_cfa_cover : null
         * can_try : null
         * catalog : null
         * isbn : null
         * large_cover : null
         * edition : null
         * discount : null
         * created_at : 2019-04-08T10:41:26.000Z
         * cart_ship : {"cart_id":4,"updated_at":"2020-06-28T07:47:25.000Z","count":1,"created_at":"2020-06-28T07:47:25.000Z","target_id":36,"id":3,"version":0,"target":"book","ordinal":null}
         * language : null
         * upload_by : null
         * cover : http://onyx-edu.oss-cn-shenzhen.aliyuncs.com/cover/nKmKNH_1561954305968.jpg
         * can_read : null
         * word_count : null
         * fav_count : null
         * file : null
         * updated_at : 2019-09-04T03:05:26.000Z
         * publish_time : 2006-02-11T00:00:00.000Z
         * price : 0
         * try_url : null
         * currency : null
         * id : 36
         * free : null
         * ebook_id : 36
         * can_buy : null
         * info : The Prince is a 16th-century political treatise by the Italian diplomat and political theorist Niccol貌 Machiavelli. From his correspondence, a version appears to have been distributed in 1513, using a Latin title, De Principatibus. However, the printed version was not published until 1532, five years after Machiavelli's death. This was carried out with the permission of the Medici pope Clement VII, but "long before then, in fact since the first appearance of The Prince in manuscript, controversy had swirled about his writings".
         * book_type : null
         * summary : null
         * star : null
         * author : Machiavelli, Niccol貌
         * authorInfo : null
         * format : epub
         * source_type : 0
         * version : 2
         * url : http://www.gutenberg.org/ebooks/1232.epub.images
         * download_count : null
         * size : 124913
         * name : The Prince
         * cfa_cover : null
         * publisher : null
         * guid : http://m.gutenberg.org/ebooks/1232.opds
         * _id : 36
         * cfa_file : null
         * view_count : null
         * md5 : null
         * status : 1
         */
        private String large_cfa_cover;
        private String can_try;
        private String catalog;
        private String isbn;
        private String large_cover;
        private String edition;
        private String discount;
        private String created_at;
        private Cart_shipEntity cart_ship;
        private String language;
        private String upload_by;
        private String cover;
        private String can_read;
        private String word_count;
        private String fav_count;
        private String file;
        private String updated_at;
        private String publish_time;
        private int price;
        private String try_url;
        private String currency;
        private int id;
        private String free;
        private int ebook_id;
        private String can_buy;
        private String info;
        private String book_type;
        private String summary;
        private String star;
        private String author;
        private String authorInfo;
        private String format;
        private int source_type;
        private int version;
        private String url;
        private String download_count;
        private int size;
        private String name;
        private String cfa_cover;
        private String publisher;
        private String guid;
        private int _id;
        private String cfa_file;
        private String view_count;
        private String md5;
        private int status;

        public void setLarge_cfa_cover(String large_cfa_cover) {
            this.large_cfa_cover = large_cfa_cover;
        }

        public void setCan_try(String can_try) {
            this.can_try = can_try;
        }

        public void setCatalog(String catalog) {
            this.catalog = catalog;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public void setLarge_cover(String large_cover) {
            this.large_cover = large_cover;
        }

        public void setEdition(String edition) {
            this.edition = edition;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public void setCart_ship(Cart_shipEntity cart_ship) {
            this.cart_ship = cart_ship;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public void setUpload_by(String upload_by) {
            this.upload_by = upload_by;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public void setCan_read(String can_read) {
            this.can_read = can_read;
        }

        public void setWord_count(String word_count) {
            this.word_count = word_count;
        }

        public void setFav_count(String fav_count) {
            this.fav_count = fav_count;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setTry_url(String try_url) {
            this.try_url = try_url;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setFree(String free) {
            this.free = free;
        }

        public void setEbook_id(int ebook_id) {
            this.ebook_id = ebook_id;
        }

        public void setCan_buy(String can_buy) {
            this.can_buy = can_buy;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public void setBook_type(String book_type) {
            this.book_type = book_type;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public void setStar(String star) {
            this.star = star;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setAuthorInfo(String authorInfo) {
            this.authorInfo = authorInfo;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public void setSource_type(int source_type) {
            this.source_type = source_type;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setDownload_count(String download_count) {
            this.download_count = download_count;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCfa_cover(String cfa_cover) {
            this.cfa_cover = cfa_cover;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public void set_id(int _id) {
            this._id = _id;
        }

        public void setCfa_file(String cfa_file) {
            this.cfa_file = cfa_file;
        }

        public void setView_count(String view_count) {
            this.view_count = view_count;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getLarge_cfa_cover() {
            return large_cfa_cover;
        }

        public String getCan_try() {
            return can_try;
        }

        public String getCatalog() {
            return catalog;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getLarge_cover() {
            return large_cover;
        }

        public String getEdition() {
            return edition;
        }

        public String getDiscount() {
            return discount;
        }

        public String getCreated_at() {
            return created_at;
        }

        public Cart_shipEntity getCart_ship() {
            return cart_ship;
        }

        public String getLanguage() {
            return language;
        }

        public String getUpload_by() {
            return upload_by;
        }

        public String getCover() {
            return cover;
        }

        public String getCan_read() {
            return can_read;
        }

        public String getWord_count() {
            return word_count;
        }

        public String getFav_count() {
            return fav_count;
        }

        public String getFile() {
            return file;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getPublish_time() {
            return publish_time;
        }

        public int getPrice() {
            return price;
        }

        public String getTry_url() {
            return try_url;
        }

        public String getCurrency() {
            return currency;
        }

        public int getId() {
            return id;
        }

        public String getFree() {
            return free;
        }

        public int getEbook_id() {
            return ebook_id;
        }

        public String getCan_buy() {
            return can_buy;
        }

        public String getInfo() {
            return info;
        }

        public String getBook_type() {
            return book_type;
        }

        public String getSummary() {
            return summary;
        }

        public String getStar() {
            return star;
        }

        public String getAuthor() {
            return author;
        }

        public String getAuthorInfo() {
            return authorInfo;
        }

        public String getFormat() {
            return format;
        }

        public int getSource_type() {
            return source_type;
        }

        public int getVersion() {
            return version;
        }

        public String getUrl() {
            return url;
        }

        public String getDownload_count() {
            return download_count;
        }

        public int getSize() {
            return size;
        }

        public String getName() {
            return name;
        }

        public String getCfa_cover() {
            return cfa_cover;
        }

        public String getPublisher() {
            return publisher;
        }

        public String getGuid() {
            return guid;
        }

        public int get_id() {
            return _id;
        }

        public String getCfa_file() {
            return cfa_file;
        }

        public String getView_count() {
            return view_count;
        }

        public String getMd5() {
            return md5;
        }

        public int getStatus() {
            return status;
        }

        public class Cart_shipEntity {
            /**
             * cart_id : 4
             * updated_at : 2020-06-28T07:47:25.000Z
             * count : 1
             * created_at : 2020-06-28T07:47:25.000Z
             * target_id : 36
             * id : 3
             * version : 0
             * target : book
             * ordinal : null
             */
            private int cart_id;
            private String updated_at;
            private int count;
            private String created_at;
            private int target_id;
            private int id;
            private int version;
            private String target;
            private String ordinal;

            public void setCart_id(int cart_id) {
                this.cart_id = cart_id;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public void setTarget_id(int target_id) {
                this.target_id = target_id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setVersion(int version) {
                this.version = version;
            }

            public void setTarget(String target) {
                this.target = target;
            }

            public void setOrdinal(String ordinal) {
                this.ordinal = ordinal;
            }

            public int getCart_id() {
                return cart_id;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public int getCount() {
                return count;
            }

            public String getCreated_at() {
                return created_at;
            }

            public int getTarget_id() {
                return target_id;
            }

            public int getId() {
                return id;
            }

            public int getVersion() {
                return version;
            }

            public String getTarget() {
                return target;
            }

            public String getOrdinal() {
                return ordinal;
            }
        }
    }
}
