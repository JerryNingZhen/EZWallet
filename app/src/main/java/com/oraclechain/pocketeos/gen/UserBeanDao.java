package com.oraclechain.pocketeos.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.oraclechain.pocketeos.bean.UserBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER_BEAN".
*/
public class UserBeanDao extends AbstractDao<UserBean, Long> {

    public static final String TABLENAME = "USER_BEAN";

    /**
     * Properties of entity UserBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Wallet_uid = new Property(1, String.class, "wallet_uid", false, "WALLET_UID");
        public final static Property Wallet_name = new Property(2, String.class, "wallet_name", false, "WALLET_NAME");
        public final static Property Wallet_img = new Property(3, String.class, "wallet_img", false, "WALLET_IMG");
        public final static Property Wallet_weixin = new Property(4, String.class, "wallet_weixin", false, "WALLET_WEIXIN");
        public final static Property Wallet_qq = new Property(5, String.class, "wallet_qq", false, "WALLET_QQ");
        public final static Property Wallet_main_account = new Property(6, String.class, "wallet_main_account", false, "WALLET_MAIN_ACCOUNT");
        public final static Property Wallet_main_account_img = new Property(7, String.class, "wallet_main_account_img", false, "WALLET_MAIN_ACCOUNT_IMG");
        public final static Property Wallet_phone = new Property(8, String.class, "wallet_phone", false, "WALLET_PHONE");
        public final static Property Wallet_shapwd = new Property(9, String.class, "wallet_shapwd", false, "WALLET_SHAPWD");
        public final static Property Password_check = new Property(10, String.class, "password_check", false, "PASSWORD_CHECK");
        public final static Property Account_info = new Property(11, String.class, "account_info", false, "ACCOUNT_INFO");
    }


    public UserBeanDao(DaoConfig config) {
        super(config);
    }
    
    public UserBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"WALLET_UID\" TEXT," + // 1: wallet_uid
                "\"WALLET_NAME\" TEXT," + // 2: wallet_name
                "\"WALLET_IMG\" TEXT," + // 3: wallet_img
                "\"WALLET_WEIXIN\" TEXT," + // 4: wallet_weixin
                "\"WALLET_QQ\" TEXT," + // 5: wallet_qq
                "\"WALLET_MAIN_ACCOUNT\" TEXT," + // 6: wallet_main_account
                "\"WALLET_MAIN_ACCOUNT_IMG\" TEXT," + // 7: wallet_main_account_img
                "\"WALLET_PHONE\" TEXT," + // 8: wallet_phone
                "\"WALLET_SHAPWD\" TEXT," + // 9: wallet_shapwd
                "\"PASSWORD_CHECK\" TEXT," + // 10: password_check
                "\"ACCOUNT_INFO\" TEXT);"); // 11: account_info
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String wallet_uid = entity.getWallet_uid();
        if (wallet_uid != null) {
            stmt.bindString(2, wallet_uid);
        }
 
        String wallet_name = entity.getWallet_name();
        if (wallet_name != null) {
            stmt.bindString(3, wallet_name);
        }
 
        String wallet_img = entity.getWallet_img();
        if (wallet_img != null) {
            stmt.bindString(4, wallet_img);
        }
 
        String wallet_weixin = entity.getWallet_weixin();
        if (wallet_weixin != null) {
            stmt.bindString(5, wallet_weixin);
        }
 
        String wallet_qq = entity.getWallet_qq();
        if (wallet_qq != null) {
            stmt.bindString(6, wallet_qq);
        }
 
        String wallet_main_account = entity.getWallet_main_account();
        if (wallet_main_account != null) {
            stmt.bindString(7, wallet_main_account);
        }
 
        String wallet_main_account_img = entity.getWallet_main_account_img();
        if (wallet_main_account_img != null) {
            stmt.bindString(8, wallet_main_account_img);
        }
 
        String wallet_phone = entity.getWallet_phone();
        if (wallet_phone != null) {
            stmt.bindString(9, wallet_phone);
        }
 
        String wallet_shapwd = entity.getWallet_shapwd();
        if (wallet_shapwd != null) {
            stmt.bindString(10, wallet_shapwd);
        }
 
        String password_check = entity.getPassword_check();
        if (password_check != null) {
            stmt.bindString(11, password_check);
        }
 
        String account_info = entity.getAccount_info();
        if (account_info != null) {
            stmt.bindString(12, account_info);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String wallet_uid = entity.getWallet_uid();
        if (wallet_uid != null) {
            stmt.bindString(2, wallet_uid);
        }
 
        String wallet_name = entity.getWallet_name();
        if (wallet_name != null) {
            stmt.bindString(3, wallet_name);
        }
 
        String wallet_img = entity.getWallet_img();
        if (wallet_img != null) {
            stmt.bindString(4, wallet_img);
        }
 
        String wallet_weixin = entity.getWallet_weixin();
        if (wallet_weixin != null) {
            stmt.bindString(5, wallet_weixin);
        }
 
        String wallet_qq = entity.getWallet_qq();
        if (wallet_qq != null) {
            stmt.bindString(6, wallet_qq);
        }
 
        String wallet_main_account = entity.getWallet_main_account();
        if (wallet_main_account != null) {
            stmt.bindString(7, wallet_main_account);
        }
 
        String wallet_main_account_img = entity.getWallet_main_account_img();
        if (wallet_main_account_img != null) {
            stmt.bindString(8, wallet_main_account_img);
        }
 
        String wallet_phone = entity.getWallet_phone();
        if (wallet_phone != null) {
            stmt.bindString(9, wallet_phone);
        }
 
        String wallet_shapwd = entity.getWallet_shapwd();
        if (wallet_shapwd != null) {
            stmt.bindString(10, wallet_shapwd);
        }
 
        String password_check = entity.getPassword_check();
        if (password_check != null) {
            stmt.bindString(11, password_check);
        }
 
        String account_info = entity.getAccount_info();
        if (account_info != null) {
            stmt.bindString(12, account_info);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public UserBean readEntity(Cursor cursor, int offset) {
        UserBean entity = new UserBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // wallet_uid
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // wallet_name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // wallet_img
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // wallet_weixin
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // wallet_qq
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // wallet_main_account
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // wallet_main_account_img
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // wallet_phone
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // wallet_shapwd
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // password_check
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11) // account_info
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setWallet_uid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setWallet_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setWallet_img(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setWallet_weixin(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setWallet_qq(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setWallet_main_account(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setWallet_main_account_img(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setWallet_phone(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setWallet_shapwd(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPassword_check(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setAccount_info(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(UserBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(UserBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(UserBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
