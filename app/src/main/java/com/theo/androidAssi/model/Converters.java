package com.theo.androidAssi.model;

import androidx.room.TypeConverter;
import com.google.gson.Gson;

public class Converters {
    private static final Gson gson = new Gson();

    @TypeConverter
    public static String fromHair(Hair hair) {
        return hair == null ? null : gson.toJson(hair);
    }

    @TypeConverter
    public static Hair toHair(String hairString) {
        return hairString == null ? null : gson.fromJson(hairString, Hair.class);
    }

    @TypeConverter
    public static String fromAddress(Address address) {
        return address == null ? null : gson.toJson(address);
    }

    @TypeConverter
    public static Address toAddress(String addressString) {
        return addressString == null ? null : gson.fromJson(addressString, Address.class);
    }

    @TypeConverter
    public static String fromBank(Bank bank) {
        return bank == null ? null : gson.toJson(bank);
    }

    @TypeConverter
    public static Bank toBank(String bankString) {
        return bankString == null ? null : gson.fromJson(bankString, Bank.class);
    }

    @TypeConverter
    public static String fromCompany(Company company) {
        return company == null ? null : gson.toJson(company);
    }

    @TypeConverter
    public static Company toCompany(String companyString) {
        return companyString == null ? null : gson.fromJson(companyString, Company.class);
    }

    @TypeConverter
    public static String fromCrypto(Crypto crypto) {
        return crypto == null ? null : gson.toJson(crypto);
    }

    @TypeConverter
    public static Crypto toCrypto(String cryptoString) {
        return cryptoString == null ? null : gson.fromJson(cryptoString, Crypto.class);
    }
}