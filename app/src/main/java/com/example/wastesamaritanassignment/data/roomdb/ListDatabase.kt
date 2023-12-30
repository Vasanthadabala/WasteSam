package com.example.wastesamaritanassignment.data.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [ListEntity::class], version = 4, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun listDao(): ListDao

    companion object {
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("CREATE TABLE list_items_temp (" +
                        "id INTEGER PRIMARY KEY NOT NULL," +
                        "name TEXT NOT NULL," +
                        "quantity INTEGER NOT NULL, rating REAL NOT NULL," +
                        "remarks TEXT NOT NULL," +
                        "image TEXT NOT NULL)")
                db.execSQL("INSERT INTO list_items_temp (id, name, quantity, rating, remarks, image)" +
                        "SELECT id, name, quantity, CAST(rating AS REAL), remarks, image FROM list_items")
                db.execSQL("DROP TABLE list_items")
                db.execSQL("ALTER TABLE list_items_temp RENAME TO list_items")
            }
        }
        val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("CREATE TABLE list_items_temp (" +
                        "id INTEGER PRIMARY KEY NOT NULL," +
                        "name TEXT NOT NULL," +
                        "quantity INTEGER NOT NULL, rating REAL NOT NULL," +
                        "remarks TEXT NOT NULL," +
                        "image TEXT NOT NULL)")
                db.execSQL("INSERT INTO list_items_temp (id, name, quantity, rating, remarks, image)" +
                        "SELECT id, name, quantity, CAST(rating AS REAL), remarks, image FROM list_items")
                db.execSQL("DROP TABLE list_items")
                db.execSQL("ALTER TABLE list_items_temp RENAME TO list_items")
            }
        }
        val MIGRATION_3_4: Migration = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
            }
        }
    }
}
