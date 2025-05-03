package com.khaled.tms.Entity;

import com.khaled.tms.Enums.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {
    private boolean isEnabled = false;
    private VerificationType verificationType;
}
