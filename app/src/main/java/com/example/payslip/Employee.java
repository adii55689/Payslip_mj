package com.example.payslip;

import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable {
    String pfNo;
    String esicNo;
    String uanNo;
    String empName;
    String adhaarNumber;
    String bankName;
    String accNo;
    String ifscCode;
    String grade;
    String presentDays;
    String arrearDays;
    String unitOfWorkDone;
    String rateOfMinWages;
    String BASIC;
    String DA;
    String otherAllowance;
    String basicEarning;
    String daEarning;
    String arrearEarning;
    String otherAllwEarning;
    String pfWages;
    String overtimeAmount;
    String HRA;
    String totalWagesPayable;
    String EPF;
    String PT;
    String ESI;
    String totalDeduction;
    String netPaid;
    String paidDate;

    public Employee(){

    }


    protected Employee(Parcel in) {
        pfNo = in.readString();
        esicNo = in.readString();
        uanNo = in.readString();
        empName = in.readString();
        adhaarNumber = in.readString();
        bankName = in.readString();
        accNo = in.readString();
        ifscCode = in.readString();
        grade = in.readString();
        presentDays = in.readString();
        arrearDays = in.readString();
        unitOfWorkDone = in.readString();
        rateOfMinWages = in.readString();
        BASIC = in.readString();
        DA = in.readString();
        otherAllowance = in.readString();
        basicEarning = in.readString();
        daEarning = in.readString();
        arrearEarning = in.readString();
        otherAllwEarning = in.readString();
        pfWages = in.readString();
        overtimeAmount = in.readString();
        HRA = in.readString();
        totalWagesPayable = in.readString();
        EPF = in.readString();
        PT = in.readString();
        ESI = in.readString();
        totalDeduction = in.readString();
        netPaid = in.readString();
        paidDate = in.readString();
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public String getPfNo() {
        return pfNo;
    }

    public void setPfNo(String pfNo) {
        this.pfNo = pfNo;
    }

    public String getEsicNo() {
        return esicNo;
    }

    public void setEsicNo(String esicNo) {
        this.esicNo = esicNo;
    }

    public String getUanNo() {
        return uanNo;
    }

    public void setUanNo(String uanNo) {
        this.uanNo = uanNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAdhaarNumber() {
        return adhaarNumber;
    }

    public void setAdhaarNumber(String adhaarNumber) {
        this.adhaarNumber = adhaarNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pfNo);
        dest.writeString(esicNo);
        dest.writeString(uanNo);
        dest.writeString(empName);
        dest.writeString(adhaarNumber);
        dest.writeString(bankName);
        dest.writeString(accNo);
        dest.writeString(ifscCode);
        dest.writeString(grade);
        dest.writeString(presentDays);
        dest.writeString(arrearDays);
        dest.writeString(unitOfWorkDone);
        dest.writeString(rateOfMinWages);
        dest.writeString(BASIC);
        dest.writeString(DA);
        dest.writeString(otherAllowance);
        dest.writeString(basicEarning);
        dest.writeString(daEarning);
        dest.writeString(arrearEarning);
        dest.writeString(otherAllwEarning);
        dest.writeString(pfWages);
        dest.writeString(overtimeAmount);
        dest.writeString(HRA);
        dest.writeString(totalWagesPayable);
        dest.writeString(EPF);
        dest.writeString(PT);
        dest.writeString(ESI);
        dest.writeString(totalDeduction);
        dest.writeString(netPaid);
        dest.writeString(paidDate);
    }

    @Override
    public String toString() {
        return this.getEmpName();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPresentDays() {
        return presentDays;
    }

    public void setPresentDays(String presentDays) {
        this.presentDays = presentDays;
    }

    public String getArrearDays() {
        return arrearDays;
    }

    public void setArrearDays(String arrearDays) {
        this.arrearDays = arrearDays;
    }

    public String getUnitOfWorkDone() {
        return unitOfWorkDone;
    }

    public void setUnitOfWorkDone(String unitOfWorkDone) {
        this.unitOfWorkDone = unitOfWorkDone;
    }

    public String getRateOfMinWages() {
        return rateOfMinWages;
    }

    public void setRateOfMinWages(String rateOfMinWages) {
        this.rateOfMinWages = rateOfMinWages;
    }

    public String getBASIC() {
        return BASIC;
    }

    public void setBASIC(String BASIC) {
        this.BASIC = BASIC;
    }

    public String getDA() {
        return DA;
    }

    public void setDA(String DA) {
        this.DA = DA;
    }

    public String getOtherAllowance() {
        return otherAllowance;
    }

    public void setOtherAllowance(String otherAllowance) {
        this.otherAllowance = otherAllowance;
    }

    public String getBasicEarning() {
        return basicEarning;
    }

    public void setBasicEarning(String basicEarning) {
        this.basicEarning = basicEarning;
    }

    public String getDaEarning() {
        return daEarning;
    }

    public void setDaEarning(String daEarning) {
        this.daEarning = daEarning;
    }

    public String getArrearEarning() {
        return arrearEarning;
    }

    public void setArrearEarning(String arrearEarning) {
        this.arrearEarning = arrearEarning;
    }

    public String getOtherAllwEarning() {
        return otherAllwEarning;
    }

    public void setOtherAllwEarning(String otherAllwEarning) {
        this.otherAllwEarning = otherAllwEarning;
    }

    public String getPfWages() {
        return pfWages;
    }

    public void setPfWages(String pfWages) {
        this.pfWages = pfWages;
    }

    public String getOvertimeAmount() {
        return overtimeAmount;
    }

    public void setOvertimeAmount(String overtimeAmount) {
        this.overtimeAmount = overtimeAmount;
    }

    public String getHRA() {
        return HRA;
    }

    public void setHRA(String HRA) {
        this.HRA = HRA;
    }

    public String getTotalWagesPayable() {
        return totalWagesPayable;
    }

    public void setTotalWagesPayable(String totalWagesPayable) {
        this.totalWagesPayable = totalWagesPayable;
    }

    public String getEPF() {
        return EPF;
    }

    public void setEPF(String EPF) {
        this.EPF = EPF;
    }

    public String getPT() {
        return PT;
    }

    public void setPT(String PT) {
        this.PT = PT;
    }

    public String getESI() {
        return ESI;
    }

    public void setESI(String ESI) {
        this.ESI = ESI;
    }

    public String getTotalDeduction() {
        return totalDeduction;
    }

    public void setTotalDeduction(String totalDeduction) {
        this.totalDeduction = totalDeduction;
    }

    public String getNetPaid() {
        return netPaid;
    }

    public void setNetPaid(String netPaid) {
        this.netPaid = netPaid;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }
}
