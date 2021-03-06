package com.hankkin.reading.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.hankkin.reading.domain.HotBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "HOT_BEAN".
*/
public class HotBeanDao extends AbstractDao<HotBean, Long> {

    public static final String TABLENAME = "HOT_BEAN";

    /**
     * Properties of entity HotBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Link = new Property(2, String.class, "link", false, "LINK");
        public final static Property Order = new Property(3, int.class, "order", false, "ORDER");
        public final static Property Visible = new Property(4, int.class, "visible", false, "VISIBLE");
    }


    public HotBeanDao(DaoConfig config) {
        super(config);
    }
    
    public HotBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HOT_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"LINK\" TEXT," + // 2: link
                "\"ORDER\" INTEGER NOT NULL ," + // 3: order
                "\"VISIBLE\" INTEGER NOT NULL );"); // 4: visible
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HOT_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, HotBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String link = entity.getLink();
        if (link != null) {
            stmt.bindString(3, link);
        }
        stmt.bindLong(4, entity.getOrder());
        stmt.bindLong(5, entity.getVisible());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, HotBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String link = entity.getLink();
        if (link != null) {
            stmt.bindString(3, link);
        }
        stmt.bindLong(4, entity.getOrder());
        stmt.bindLong(5, entity.getVisible());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public HotBean readEntity(Cursor cursor, int offset) {
        HotBean entity = new HotBean( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // link
            cursor.getInt(offset + 3), // order
            cursor.getInt(offset + 4) // visible
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, HotBean entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLink(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setOrder(cursor.getInt(offset + 3));
        entity.setVisible(cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(HotBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(HotBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(HotBean entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
